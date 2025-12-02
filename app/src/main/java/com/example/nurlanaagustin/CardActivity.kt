package com.example.nurlanaagustin

import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        // Handle tombol Back dengan cara baru
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showExitDialog()
            }
        })

        // Card Profile - Navigasi ke ProfileActivity
        findViewById<CardView>(R.id.cardProfile).setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        // Card Form - Navigasi ke FormActivity
        findViewById<CardView>(R.id.cardForm).setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }

        // Card Calculator - Navigasi ke CalculatorActivity
        findViewById<CardView>(R.id.cardCalculator).setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        // Card Form Transaksi - Navigasi ke FormTransaksiActivity
        findViewById<CardView>(R.id.cardFormTransaksi).setOnClickListener {
            val intent = Intent(this, FormTransaksiActivity::class.java)
            startActivity(intent)
        }

        // Card Konversi Suhu - Navigasi ke KonversiSuhuActivity
        findViewById<CardView>(R.id.cardKonversiSuhu).setOnClickListener {
            val intent = Intent(this, KonversiSuhuActivity::class.java)
            startActivity(intent)
        }

        // Card Exit - Tampilkan dialog konfirmasi keluar
        findViewById<CardView>(R.id.cardExit).setOnClickListener {
            showExitDialog()
        }
    }

    // Fungsi untuk menampilkan dialog konfirmasi keluar
    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Konfirmasi")
        builder.setMessage("Yakin ingin keluar?")

        // Tombol Ya - Keluar dari aplikasi
        builder.setPositiveButton("Ya") { dialog, which ->
            finishAffinity() // Menutup semua activity dan keluar dari aplikasi
        }

        // Tombol Tidak - Tetap di aplikasi
        builder.setNegativeButton("Tidak") { dialog, which ->
            dialog.dismiss() // Menutup dialog
        }

        // Agar dialog tidak tertutup saat tap di luar area dialog
        builder.setCancelable(true)

        // Tampilkan dialog
        val dialog = builder.create()
        dialog.show()
    }
}