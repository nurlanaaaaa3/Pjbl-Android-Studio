package com.example.nurlanaagustin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    // Deklarasi Views
    private lateinit var profileImage: ImageView
    private lateinit var nameText: TextView
    private lateinit var bioText: TextView
    private lateinit var birthDateText: TextView
    private lateinit var addressText: TextView
    private lateinit var jobText: TextView
    private lateinit var emailText: TextView
    private lateinit var phoneText: TextView
    private lateinit var instagramText: TextView
    private lateinit var whatsappText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pastikan layout file bernama activity_profile.xml di folder res/layout
        val layoutId = resources.getIdentifier("activity_profile", "layout", packageName)
        if (layoutId != 0) {
            setContentView(layoutId)
            initViews()
            setProfileData()
        }
    }

    private fun initViews() {
        try {
            profileImage = findViewById(getResId("profileImage", "id"))
            nameText = findViewById(getResId("nameText", "id"))
            bioText = findViewById(getResId("bioText", "id"))
            birthDateText = findViewById(getResId("birthDateText", "id"))
            addressText = findViewById(getResId("addressText", "id"))
            jobText = findViewById(getResId("jobText", "id"))
            emailText = findViewById(getResId("emailText", "id"))
            phoneText = findViewById(getResId("phoneText", "id"))
            instagramText = findViewById(getResId("instagramText", "id"))
            whatsappText = findViewById(getResId("whatsappText", "id"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setProfileData() {
        nameText.text = "Nur Lana Agustin"
        bioText.text = "Pecinta Kopi!"
        birthDateText.text = "10 Agustus 2009"
        addressText.text = "Kerten, Laweyan, Surakarta, Jawa Tengah"
        jobText.text = "Smk Negeri 6 Surakarta"
        emailText.text = "nurlana123ok@gmail.com"
        phoneText.text = "+62 889-8598-4393"
        instagramText.text = "nurlnaaa_"
        whatsappText.text = "nurlnaaa_"

        // Set profile image
        val imageId = getResId("foto", "drawable")
        if (imageId != 0) {
            profileImage.setImageResource(imageId)
        }
    }

    // Helper function untuk mendapatkan resource ID
    private fun getResId(resourceName: String, resourceType: String): Int {
        return resources.getIdentifier(resourceName, resourceType, packageName)
    }

    // Fungsi tambahan untuk update profil
    fun updateProfile(
        name: String,
        bio: String,
        birthDate: String,
        address: String,
        education: String,
        email: String,
        phone: String,
        instagram: String,
        twitter: String
    ) {
        nameText.text = name
        bioText.text = bio
        birthDateText.text = birthDate
        addressText.text = address
        jobText.text = education
        emailText.text = email
        phoneText.text = phone
        instagramText.text = instagram
        whatsappText.text = twitter
    }
}