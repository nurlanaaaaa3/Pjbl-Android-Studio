package com.example.nurlanaagustin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormActivity : AppCompatActivity() {
    // Variabel sesuai XML
    lateinit var etNama: EditText
    lateinit var etAlamat: EditText
    lateinit var etNoHP: EditText
    lateinit var spinnerAgama: Spinner
    lateinit var rgJenisKelamin: RadioGroup
    lateinit var cbMembaca: CheckBox
    lateinit var cbMakan: CheckBox
    lateinit var cbTidur: CheckBox
    lateinit var cbOlahraga: CheckBox
    lateinit var btnSimpan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form)
        init()

        // Setup Spinner Agama
        setupSpinner()

        // Koneksi ke HasilFormActivity
        btnSimpan.setOnClickListener {
            // Validasi input
            if (validateInput()) {
                // Ambil data Nama, Alamat, No HP
                val nama = etNama.text.toString()
                val alamat = etAlamat.text.toString()
                val nomorhp = etNoHP.text.toString()

                // Ambil data Agama dari Spinner
                val agama = spinnerAgama.selectedItem.toString()

                // Ambil data Jenis Kelamin dari RadioGroup
                val selectedGenderId = rgJenisKelamin.checkedRadioButtonId
                val jeniskelamin = when (selectedGenderId) {
                    R.id.rbLakiLaki -> "Laki-laki"
                    R.id.rbPerempuan -> "Perempuan"
                    else -> "-"
                }

                // Ambil data Hobi dari CheckBox
                val hobiList = mutableListOf<String>()
                if (cbMembaca.isChecked) hobiList.add("Membaca")
                if (cbMakan.isChecked) hobiList.add("Makan")
                if (cbTidur.isChecked) hobiList.add("Tidur")
                if (cbOlahraga.isChecked) hobiList.add("Olahraga")
                val hobi = if (hobiList.isNotEmpty()) hobiList.joinToString(", ") else "-"

                // Buat Intent ke HasilFormActivity
                val keHasil = Intent(this, HasilFormActivity::class.java)

                // Kirim semua data
                keHasil.putExtra("nama", nama)
                keHasil.putExtra("alamat", alamat)
                keHasil.putExtra("nomorhp", nomorhp)
                keHasil.putExtra("agama", agama)
                keHasil.putExtra("jeniskelamin", jeniskelamin)
                keHasil.putExtra("hobi", hobi)

                // Pindah ke HasilFormActivity
                startActivity(keHasil)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupSpinner() {
        val agamaList = arrayOf("Pilih Agama", "Islam", "Kristen", "Katolik", "Hindu", "Buddha", "Konghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, agamaList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerAgama.adapter = adapter
    }

    private fun validateInput(): Boolean {
        // Cek Nama
        if (etNama.text.toString().trim().isEmpty()) {
            etNama.error = "Nama harus diisi"
            etNama.requestFocus()
            return false
        }

        // Cek Alamat
        if (etAlamat.text.toString().trim().isEmpty()) {
            etAlamat.error = "Alamat harus diisi"
            etAlamat.requestFocus()
            return false
        }

        // Cek No HP
        if (etNoHP.text.toString().trim().isEmpty()) {
            etNoHP.error = "No HP harus diisi"
            etNoHP.requestFocus()
            return false
        }

        // Cek Agama
        if (spinnerAgama.selectedItemPosition == 0) {
            Toast.makeText(this, "Pilih agama terlebih dahulu", Toast.LENGTH_SHORT).show()
            return false
        }

        // Cek Jenis Kelamin
        if (rgJenisKelamin.checkedRadioButtonId == -1) {
            Toast.makeText(this, "Pilih jenis kelamin terlebih dahulu", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun init() {
        etNama = findViewById(R.id.etNama)
        etAlamat = findViewById(R.id.etAlamat)
        etNoHP = findViewById(R.id.etNoHP)
        spinnerAgama = findViewById(R.id.spinnerAgama)
        rgJenisKelamin = findViewById(R.id.rgJenisKelamin)
        cbMembaca = findViewById(R.id.cbMembaca)
        cbMakan = findViewById(R.id.cbMakan)
        cbTidur = findViewById(R.id.cbTidur)
        cbOlahraga = findViewById(R.id.cbOlahraga)
        btnSimpan = findViewById(R.id.btnSimpan)
    }
}