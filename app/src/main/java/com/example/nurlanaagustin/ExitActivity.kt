package com.example.nurlanaagustin

import android.os.Bundle
import android.widget.Button
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * ExitActivity memuat activity_exit.xml dan menyediakan fungsi untuk tombol keluar.
 */
class ExitActivity : AppCompatActivity() {

    private val TAG = "ExitActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pengaturan dasar Activity dari kode yang Anda berikan
        enableEdgeToEdge()
        setContentView(R.layout.activity_exit) // Asumsi nama file XML adalah activity_exit.xml

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // --- LOGIKA TOMBOL KELUAR DITAMBAHKAN DI SINI ---

        // 1. Dapatkan referensi ke tombol "Keluar"
        //    Asumsi: Tombol di activity_exit.xml memiliki ID 'exitButton'
        try {
            // Ganti 'R.id.exitButton' jika ID tombol Anda berbeda di 'activity_exit.xml'
            val exitButton: Button = findViewById(R.id.exitButton)

            // 2. Tetapkan fungsi klik
            exitButton.setOnClickListener {
                Log.i(TAG, "Tombol 'Keluar' dari ExitActivity diklik. Menutup Activity.")

                // Perintah untuk menutup Activity ini
                finish()
            }
        } catch (e: Exception) {
            // Pesan error jika tombol tidak ditemukan di layout
            Log.e(TAG, "Gagal menemukan tombol 'exitButton' di activity_exit.xml: ${e.message}")
        }
        // ------------------------------------------------
    }
}