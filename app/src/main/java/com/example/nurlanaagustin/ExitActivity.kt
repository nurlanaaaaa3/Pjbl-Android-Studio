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

    companion object {
        private const val TAG = "ExitActivityLifecycle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Pengaturan dasar Activity
        enableEdgeToEdge()
        setContentView(R.layout.activity_exit)

        // Setup window insets dengan null-safety
        findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)?.let { mainView ->
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        // Setup tombol keluar
        setupExitButton()
    }

    private fun setupExitButton() {
        // Cari tombol dengan ID exitButton
        val exitButton: Button? = findViewById(R.id.exitButton)

        if (exitButton != null) {
            exitButton.setOnClickListener {
                Log.i(TAG, "Tombol 'Keluar' diklik. Menutup Activity.")
                finish()
            }
        } else {
            Log.e(TAG, "Tombol 'exitButton' tidak ditemukan di layout activity_exit.xml")
        }
    }
}