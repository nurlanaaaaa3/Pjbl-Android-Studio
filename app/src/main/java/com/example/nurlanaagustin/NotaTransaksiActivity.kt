package com.example.nurlanaagustin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class NotaTransaksiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_transaksi)

        // Ambil data dari Intent - SESUAIKAN DENGAN KEY DARI FORM!
        val namaPemesan = intent.getStringExtra("namaPemesan") ?: "-"
        val nomorMeja = intent.getStringExtra("nomorMeja") ?: "-"

        // Data Snack
        val jmlFrenchfries = intent.getIntExtra("jmlFrenchfries", 0)
        val jmlRisol = intent.getIntExtra("jmlRisol", 0)
        val jmlCroffle = intent.getIntExtra("jmlCroffle", 0)
        val jmlDonat = intent.getIntExtra("jmlDonat", 0)
        val jmlDimsumMentai = intent.getIntExtra("jmlDimsumMentai", 0)

        // Data Makanan
        val jmlChickenSteak = intent.getIntExtra("jmlChickenSteak", 0)
        val jmlSpaghetti = intent.getIntExtra("jmlSpaghettiCarbonara", 0)
        val jmlRiceBowl = intent.getIntExtra("jmlRicebowl", 0)
        val jmlAyamGeprek = intent.getIntExtra("jmlAyamGeprek", 0)
        val jmlBurger = intent.getIntExtra("jmlChickenBurgerCrispy", 0)

        // Data Minuman
        val jmlEsTeh = intent.getIntExtra("jmlEsTeh", 0)
        val jmlEsJeruk = intent.getIntExtra("jmlEsJeruk", 0)
        val jmlKopiGula = intent.getIntExtra("jmlKopiSusuGulaAren", 0)
        val jmlDalgona = intent.getIntExtra("jmlDalgonaCoffee", 0)
        val jmlLemonTea = intent.getIntExtra("jmlEsLemonTea", 0)
        val jmlMatcha = intent.getIntExtra("jmlMatchaLatte", 0)

        val totalHarga = intent.getIntExtra("totalHarga", 0)

        // Inisialisasi Views
        val tvNamaPemesan: TextView = findViewById(R.id.tvNamaPemesan)
        val tvNomorMeja: TextView = findViewById(R.id.tvNomorMeja)
        val tvDetailPesanan: TextView = findViewById(R.id.tvDetailPesanan)
        val tvTotalHarga: TextView = findViewById(R.id.tvTotalHarga)
        val btnKembaliKeForm: Button = findViewById(R.id.btnKembaliKeForm)

        // Set data ke TextView
        tvNamaPemesan.text = "Nama: $namaPemesan"
        tvNomorMeja.text = "Meja: $nomorMeja"

        // Build detail pesanan
        val detailPesanan = buildDetailPesanan(
            jmlFrenchfries, jmlRisol, jmlCroffle, jmlDonat, jmlDimsumMentai,
            jmlChickenSteak, jmlSpaghetti, jmlRiceBowl, jmlAyamGeprek, jmlBurger,
            jmlEsTeh, jmlEsJeruk, jmlKopiGula, jmlDalgona, jmlLemonTea, jmlMatcha
        )

        tvDetailPesanan.text = detailPesanan
        tvTotalHarga.text = "TOTAL: Rp ${formatRupiah(totalHarga)}"

        // Tombol Kembali ke Form
        btnKembaliKeForm.setOnClickListener {
            finish()
        }

        // Long press untuk share nota
        btnKembaliKeForm.setOnLongClickListener {
            bagikanNota(namaPemesan, nomorMeja, detailPesanan, totalHarga)
            true
        }
    }

    private fun buildDetailPesanan(
        // Snack
        jmlFrenchfries: Int, jmlRisol: Int, jmlCroffle: Int, jmlDonat: Int, jmlDimsumMentai: Int,
        // Makanan
        jmlChickenSteak: Int, jmlSpaghetti: Int, jmlRiceBowl: Int, jmlAyamGeprek: Int, jmlBurger: Int,
        // Minuman
        jmlEsTeh: Int, jmlEsJeruk: Int, jmlKopiGula: Int, jmlDalgona: Int, jmlLemonTea: Int, jmlMatcha: Int
    ): String {
        return buildString {
            var itemCount = 0

            // Cek apakah ada snack
            val adaSnack = jmlFrenchfries > 0 || jmlRisol > 0 || jmlCroffle > 0 ||
                    jmlDonat > 0 || jmlDimsumMentai > 0

            // Cek apakah ada makanan
            val adaMakanan = jmlChickenSteak > 0 || jmlSpaghetti > 0 || jmlRiceBowl > 0 ||
                    jmlAyamGeprek > 0 || jmlBurger > 0

            // Cek apakah ada minuman
            val adaMinuman = jmlEsTeh > 0 || jmlEsJeruk > 0 || jmlKopiGula > 0 ||
                    jmlDalgona > 0 || jmlLemonTea > 0 || jmlMatcha > 0

            // SNACK
            if (adaSnack) {
                append("━━━━━━━━━━━━━━━━━━━━\n")
                append("🍟 SNACK\n")
                append("━━━━━━━━━━━━━━━━━━━━\n\n")
            }

            if (jmlFrenchfries > 0) {
                itemCount++
                append("$itemCount. French Fries\n")
                append("    $jmlFrenchfries x Rp 15.000\n")
                append("    = Rp ${formatRupiah(15000 * jmlFrenchfries)}\n\n")
            }
            if (jmlRisol > 0) {
                itemCount++
                append("$itemCount. Risol\n")
                append("    $jmlRisol x Rp 6.000\n")
                append("    = Rp ${formatRupiah(6000 * jmlRisol)}\n\n")
            }
            if (jmlCroffle > 0) {
                itemCount++
                append("$itemCount. Croffle\n")
                append("    $jmlCroffle x Rp 14.000\n")
                append("    = Rp ${formatRupiah(14000 * jmlCroffle)}\n\n")
            }
            if (jmlDonat > 0) {
                itemCount++
                append("$itemCount. Donat\n")
                append("    $jmlDonat x Rp 8.000\n")
                append("    = Rp ${formatRupiah(8000 * jmlDonat)}\n\n")
            }
            if (jmlDimsumMentai > 0) {
                itemCount++
                append("$itemCount. Dimsum Mentai\n")
                append("    $jmlDimsumMentai x Rp 12.000\n")
                append("    = Rp ${formatRupiah(12000 * jmlDimsumMentai)}\n\n")
            }

            // MAKANAN
            if (adaMakanan) {
                if (adaSnack) append("\n")
                append("━━━━━━━━━━━━━━━━━━━━\n")
                append("🍴 MAKANAN\n")
                append("━━━━━━━━━━━━━━━━━━━━\n\n")
                itemCount = 0 // Reset nomor
            }

            if (jmlChickenSteak > 0) {
                itemCount++
                append("$itemCount. Chicken Steak\n")
                append("    $jmlChickenSteak x Rp 22.000\n")
                append("    = Rp ${formatRupiah(22000 * jmlChickenSteak)}\n\n")
            }
            if (jmlSpaghetti > 0) {
                itemCount++
                append("$itemCount. Spaghetti Carbonara\n")
                append("    $jmlSpaghetti x Rp 15.000\n")
                append("    = Rp ${formatRupiah(15000 * jmlSpaghetti)}\n\n")
            }
            if (jmlRiceBowl > 0) {
                itemCount++
                append("$itemCount. Rice Bowl\n")
                append("    $jmlRiceBowl x Rp 12.000\n")
                append("    = Rp ${formatRupiah(12000 * jmlRiceBowl)}\n\n")
            }
            if (jmlAyamGeprek > 0) {
                itemCount++
                append("$itemCount. Ayam Geprek\n")
                append("    $jmlAyamGeprek x Rp 10.000\n")
                append("    = Rp ${formatRupiah(10000 * jmlAyamGeprek)}\n\n")
            }
            if (jmlBurger > 0) {
                itemCount++
                append("$itemCount. Chicken Burger Crispy\n")
                append("    $jmlBurger x Rp 27.000\n")
                append("    = Rp ${formatRupiah(27000 * jmlBurger)}\n\n")
            }

            // MINUMAN
            if (adaMinuman) {
                if (adaSnack || adaMakanan) append("\n")
                append("━━━━━━━━━━━━━━━━━━━━\n")
                append("☕ MINUMAN\n")
                append("━━━━━━━━━━━━━━━━━━━━\n\n")
                itemCount = 0 // Reset nomor
            }

            if (jmlEsTeh > 0) {
                itemCount++
                append("$itemCount. Es Teh\n")
                append("    $jmlEsTeh x Rp 5.000\n")
                append("    = Rp ${formatRupiah(5000 * jmlEsTeh)}\n\n")
            }
            if (jmlEsJeruk > 0) {
                itemCount++
                append("$itemCount. Es Jeruk\n")
                append("    $jmlEsJeruk x Rp 5.000\n")
                append("    = Rp ${formatRupiah(5000 * jmlEsJeruk)}\n\n")
            }
            if (jmlKopiGula > 0) {
                itemCount++
                append("$itemCount. Kopi Susu Gula Aren\n")
                append("    $jmlKopiGula x Rp 17.000\n")
                append("    = Rp ${formatRupiah(17000 * jmlKopiGula)}\n\n")
            }
            if (jmlDalgona > 0) {
                itemCount++
                append("$itemCount. Dalgona Coffee\n")
                append("    $jmlDalgona x Rp 22.000\n")
                append("    = Rp ${formatRupiah(22000 * jmlDalgona)}\n\n")
            }
            if (jmlLemonTea > 0) {
                itemCount++
                append("$itemCount. Es Lemon Tea\n")
                append("    $jmlLemonTea x Rp 6.000\n")
                append("    = Rp ${formatRupiah(6000 * jmlLemonTea)}\n\n")
            }
            if (jmlMatcha > 0) {
                itemCount++
                append("$itemCount. Matcha Latte\n")
                append("    $jmlMatcha x Rp 20.000\n")
                append("    = Rp ${formatRupiah(20000 * jmlMatcha)}\n\n")
            }

            // Footer
            if (adaSnack || adaMakanan || adaMinuman) {
                append("━━━━━━━━━━━━━━━━━━━━")
            } else {
                append("Tidak ada pesanan")
            }
        }
    }

    private fun bagikanNota(
        nama: String,
        meja: String,
        detail: String,
        total: Int
    ) {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("id", "ID"))
        val tanggalWaktu = dateFormat.format(Date())

        val notaText = buildString {
            append("╔════════════════════════╗\n")
            append("║   CAFE LANARIA.   ║\n")
            append("║   NOTA TRANSAKSI   ║\n")
            append("╚════════════════════════╝\n\n")
            append("Tanggal: $tanggalWaktu\n")
            append("Nama   : $nama\n")
            append("Meja   : $meja\n\n")
            append(detail.replace("━", "="))
            append("\n\n")
            append("════════════════════════\n")
            append("TOTAL: Rp ${formatRupiah(total)}\n")
            append("════════════════════════\n\n")
            append("Terima kasih atas\nkunjungan Anda! 🙏")
        }

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, notaText)
            type = "text/plain"
        }

        try {
            startActivity(Intent.createChooser(shareIntent, "Bagikan Nota via"))
        } catch (e: Exception) {
            Toast.makeText(this, "Tidak dapat membagikan nota", Toast.LENGTH_SHORT).show()
        }
    }

    private fun formatRupiah(angka: Int): String {
        return String.format("%,d", angka).replace(',', '.')
    }
}