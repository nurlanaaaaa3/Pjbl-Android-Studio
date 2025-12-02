package com.example.nurlanaagustin

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilFormActivity : AppCompatActivity() { // Ganti nama class
    private lateinit var tvNama: TextView
    private lateinit var tvAlamat: TextView
    private lateinit var tvNomorHP: TextView
    private lateinit var tvAgama: TextView
    private lateinit var tvJenisKelamin: TextView
    private lateinit var tvHobi: TextView
    private lateinit var btnKembali: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hasil_form)
        init()

        // Terima data dari FormActivity
        val nama = intent.getStringExtra("nama") ?: "-"
        val alamat = intent.getStringExtra("alamat") ?: "-"
        val nomorhp = intent.getStringExtra("nomorhp") ?: "-"
        val agama = intent.getStringExtra("agama") ?: "-"
        val jeniskelamin = intent.getStringExtra("jeniskelamin") ?: "-"
        val hobi = intent.getStringExtra("hobi") ?: "-"

        // Tampilkan data dengan format yang lebih rapi
        tvNama.text = "Nama: $nama"
        tvAlamat.text = "Alamat: $alamat"
        tvNomorHP.text = "No HP: $nomorhp"
        tvAgama.text = "Agama: $agama"
        tvJenisKelamin.text = "Jenis Kelamin: $jeniskelamin"
        tvHobi.text = "Hobi: $hobi"

        // Tombol kembali
        btnKembali.setOnClickListener {
            finish() // Kembali ke FormActivity
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun init() {
        tvNama = findViewById(R.id.tvNama)
        tvAlamat = findViewById(R.id.tvAlamat)
        tvNomorHP = findViewById(R.id.tvNoHP) // Pastikan ID ini sesuai dengan XML
        tvAgama = findViewById(R.id.tvAgama)
        tvJenisKelamin = findViewById(R.id.tvJenisKelamin)
        tvHobi = findViewById(R.id.tvHobi)
        btnKembali = findViewById(R.id.btnKembali)
    }
}