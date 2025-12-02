package com.example.nurlanaagustin

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class FormTransaksiActivity : AppCompatActivity() {
    // Variabel untuk informasi pemesan
    lateinit var etNamaPemesan: EditText
    lateinit var etNomorMeja: EditText

    // Variabel untuk snack
    lateinit var etJmlFrenchfries: EditText
    lateinit var etJmlRisol: EditText
    lateinit var etJmlCroffle: EditText
    lateinit var etJmlDonat: EditText
    lateinit var etJmlDimsumMentai: EditText

    // Variabel untuk makanan
    lateinit var etJmlChickenSteak: EditText
    lateinit var etJmlSpaghettiCarbonara: EditText
    lateinit var etJmlRicebowl: EditText
    lateinit var etJmlAyamGeprek: EditText
    lateinit var etJmlChickenBurgerCrispy: EditText

    // Variabel untuk minuman
    lateinit var etJmlEsTeh: EditText
    lateinit var etJmlEsJeruk: EditText
    lateinit var etJmlKopiSusuGulaAren: EditText
    lateinit var etJmlDalgonaCoffee: EditText
    lateinit var etJmlEsLemonTea: EditText
    lateinit var etJmlMatchaLatte: EditText

    lateinit var btnHitung: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_form_transaksi)
        init()

        btnHitung.setOnClickListener {
            // Ambil nama pemesan dan nomor meja
            val namaPemesan = etNamaPemesan.text.toString()
            val nomorMeja = etNomorMeja.text.toString()

            // Validasi input
            if (namaPemesan.isEmpty()) {
                Toast.makeText(this, "Nama pemesan harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (nomorMeja.isEmpty()) {
                Toast.makeText(this, "Nomor meja harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Hitung total untuk snack
            val jmlFrenchfries = etJmlFrenchfries.text.toString().toIntOrNull() ?: 0
            val jmlRisol = etJmlRisol.text.toString().toIntOrNull() ?: 0
            val jmlCroffle = etJmlCroffle.text.toString().toIntOrNull() ?: 0
            val jmlDonat = etJmlDonat.text.toString().toIntOrNull() ?: 0
            val jmlDimsumMentai = etJmlDimsumMentai.text.toString().toIntOrNull() ?: 0

            // Hitung total untuk makanan
            val jmlChickenSteak = etJmlChickenSteak.text.toString().toIntOrNull() ?: 0
            val jmlSpaghettiCarbonara = etJmlSpaghettiCarbonara.text.toString().toIntOrNull() ?: 0
            val jmlRicebowl = etJmlRicebowl.text.toString().toIntOrNull() ?: 0
            val jmlAyamGeprek = etJmlAyamGeprek.text.toString().toIntOrNull() ?: 0
            val jmlChickenBurgerCrispy = etJmlChickenBurgerCrispy.text.toString().toIntOrNull() ?: 0

            // Hitung total untuk minuman
            val jmlEsTeh = etJmlEsTeh.text.toString().toIntOrNull() ?: 0
            val jmlEsJeruk = etJmlEsJeruk.text.toString().toIntOrNull() ?: 0
            val jmlKopiSusuGulaAren = etJmlKopiSusuGulaAren.text.toString().toIntOrNull() ?: 0
            val jmlDalgonaCoffee = etJmlDalgonaCoffee.text.toString().toIntOrNull() ?: 0
            val jmlEsLemonTea = etJmlEsLemonTea.text.toString().toIntOrNull() ?: 0
            val jmlMatchaLatte = etJmlMatchaLatte.text.toString().toIntOrNull() ?: 0

            // Harga per item - SNACK
            val hargaFrenchfries = 15000
            val hargaRisol = 6000
            val hargaCroffle = 14000
            val hargaDonat = 8000
            val hargaDimsumMentai = 12000

            // Harga per item - MAKANAN
            val hargaChickenSteak = 22000
            val hargaSpaghettiCarbonara = 15000
            val hargaRicebowl = 12000
            val hargaAyamGeprek = 10000
            val hargaChickenBurgerCrispy = 27000

            // Harga per item - MINUMAN
            val hargaEsTeh = 5000
            val hargaEsJeruk = 5000
            val hargaKopiSusuGulaAren = 17000
            val hargaDalgonaCoffee = 22000
            val hargaEsLemonTea = 6000
            val hargaMatchaLatte = 20000

            // Hitung subtotal SNACK
            val subtotalSnack = (jmlFrenchfries * hargaFrenchfries) +
                    (jmlRisol * hargaRisol) +
                    (jmlCroffle * hargaCroffle) +
                    (jmlDonat * hargaDonat) +
                    (jmlDimsumMentai * hargaDimsumMentai)

            // Hitung subtotal MAKANAN
            val subtotalMakanan = (jmlChickenSteak * hargaChickenSteak) +
                    (jmlSpaghettiCarbonara * hargaSpaghettiCarbonara) +
                    (jmlRicebowl * hargaRicebowl) +
                    (jmlAyamGeprek * hargaAyamGeprek) +
                    (jmlChickenBurgerCrispy * hargaChickenBurgerCrispy)

            // Hitung subtotal MINUMAN
            val subtotalMinuman = (jmlEsTeh * hargaEsTeh) +
                    (jmlEsJeruk * hargaEsJeruk) +
                    (jmlKopiSusuGulaAren * hargaKopiSusuGulaAren) +
                    (jmlDalgonaCoffee * hargaDalgonaCoffee) +
                    (jmlEsLemonTea * hargaEsLemonTea) +
                    (jmlMatchaLatte * hargaMatchaLatte)

            val totalHarga = subtotalSnack + subtotalMakanan + subtotalMinuman

            // Validasi apakah ada pesanan
            if (totalHarga == 0) {
                Toast.makeText(this, "Pilih minimal 1 menu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buat intent ke NotaTransaksiActivity
            val keNota = Intent(this, NotaTransaksiActivity::class.java)

            // Kirim data pemesan
            keNota.putExtra("namaPemesan", namaPemesan)
            keNota.putExtra("nomorMeja", nomorMeja)

            // Kirim data snack
            keNota.putExtra("jmlFrenchfries", jmlFrenchfries)
            keNota.putExtra("jmlRisol", jmlRisol)
            keNota.putExtra("jmlCroffle", jmlCroffle)
            keNota.putExtra("jmlDonat", jmlDonat)
            keNota.putExtra("jmlDimsumMentai", jmlDimsumMentai)

            // Kirim data makanan
            keNota.putExtra("jmlChickenSteak", jmlChickenSteak)
            keNota.putExtra("jmlSpaghettiCarbonara", jmlSpaghettiCarbonara)
            keNota.putExtra("jmlRicebowl", jmlRicebowl)
            keNota.putExtra("jmlAyamGeprek", jmlAyamGeprek)
            keNota.putExtra("jmlChickenBurgerCrispy", jmlChickenBurgerCrispy)

            // Kirim data minuman
            keNota.putExtra("jmlEsTeh", jmlEsTeh)
            keNota.putExtra("jmlEsJeruk", jmlEsJeruk)
            keNota.putExtra("jmlKopiSusuGulaAren", jmlKopiSusuGulaAren)
            keNota.putExtra("jmlDalgonaCoffee", jmlDalgonaCoffee)
            keNota.putExtra("jmlEsLemonTea", jmlEsLemonTea)
            keNota.putExtra("jmlMatchaLatte", jmlMatchaLatte)

            // Kirim total
            keNota.putExtra("subtotalSnack", subtotalSnack)
            keNota.putExtra("subtotalMakanan", subtotalMakanan)
            keNota.putExtra("subtotalMinuman", subtotalMinuman)
            keNota.putExtra("totalHarga", totalHarga)

            startActivity(keNota)
        }
    }

    private fun init() {
        // Inisialisasi informasi pemesan
        etNamaPemesan = findViewById(R.id.etNamaPemesan)
        etNomorMeja = findViewById(R.id.etNomorMeja)

        // Inisialisasi snack
        etJmlFrenchfries = findViewById(R.id.etJmlFrenchfries)
        etJmlRisol = findViewById(R.id.etJmlRisol)
        etJmlCroffle = findViewById(R.id.etJmlCroffle)
        etJmlDonat = findViewById(R.id.etJmlDonat)
        etJmlDimsumMentai = findViewById(R.id.etJmlDimsumMentai)

        // Inisialisasi makanan
        etJmlChickenSteak = findViewById(R.id.etJmlChickenSteak)
        etJmlSpaghettiCarbonara = findViewById(R.id.etJmlSpaghettiCarbonara)
        etJmlRicebowl = findViewById(R.id.etJmlRicebowl)
        etJmlAyamGeprek = findViewById(R.id.etJmlAyamGeprek)
        etJmlChickenBurgerCrispy = findViewById(R.id.etJmlChickenBurgerCrispy)

        // Inisialisasi minuman
        etJmlEsTeh = findViewById(R.id.etJmlEsTeh)
        etJmlEsJeruk = findViewById(R.id.etJmlEsJeruk)
        etJmlKopiSusuGulaAren = findViewById(R.id.etJmlKopiSusuGulaAren)
        etJmlDalgonaCoffee = findViewById(R.id.etJmlDalgonaCoffee)
        etJmlEsLemonTea = findViewById(R.id.etJmlEsLemonTea)
        etJmlMatchaLatte = findViewById(R.id.etJmlMatchaLatte)

        // Inisialisasi button
        btnHitung = findViewById(R.id.btnHitung)
    }
}