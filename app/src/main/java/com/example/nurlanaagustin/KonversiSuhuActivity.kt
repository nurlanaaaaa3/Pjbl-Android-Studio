package com.example.nurlanaagustin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class KonversiSuhuActivity : AppCompatActivity() {

    private lateinit var etCelsius: EditText
    private lateinit var etFahrenheit: EditText
    private lateinit var etKelvin: EditText
    private lateinit var btnHapus: Button

    private var isUpdating = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konversi_suhu)

        // Inisialisasi views
        etCelsius = findViewById(R.id.etCelsius)
        etFahrenheit = findViewById(R.id.etfahrenheit)
        etKelvin = findViewById(R.id.etFahrenheit)
        btnHapus = findViewById(R.id.btnhapus)

        // Setup TextWatcher untuk Celsius
        etCelsius.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!isUpdating && s.toString().isNotEmpty()) {
                    isUpdating = true
                    try {
                        val celsius = s.toString().toDouble()
                        val fahrenheit = (celsius * 9/5) + 32
                        val kelvin = celsius + 273.15

                        etFahrenheit.setText(String.format("%.2f", fahrenheit))
                        etKelvin.setText(String.format("%.2f", kelvin))
                    } catch (e: NumberFormatException) {
                        // Ignore invalid input
                    }
                    isUpdating = false
                }
            }
        })

        // Setup TextWatcher untuk Fahrenheit
        etFahrenheit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!isUpdating && s.toString().isNotEmpty()) {
                    isUpdating = true
                    try {
                        val fahrenheit = s.toString().toDouble()
                        val celsius = (fahrenheit - 32) * 5/9
                        val kelvin = celsius + 273.15

                        etCelsius.setText(String.format("%.2f", celsius))
                        etKelvin.setText(String.format("%.2f", kelvin))
                    } catch (e: NumberFormatException) {
                        // Ignore invalid input
                    }
                    isUpdating = false
                }
            }
        })

        // Setup TextWatcher untuk Kelvin
        etKelvin.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!isUpdating && s.toString().isNotEmpty()) {
                    isUpdating = true
                    try {
                        val kelvin = s.toString().toDouble()
                        val celsius = kelvin - 273.15
                        val fahrenheit = (celsius * 9/5) + 32

                        etCelsius.setText(String.format("%.2f", celsius))
                        etFahrenheit.setText(String.format("%.2f", fahrenheit))
                    } catch (e: NumberFormatException) {
                        // Ignore invalid input
                    }
                    isUpdating = false
                }
            }
        })

        // Setup button hapus
        btnHapus.setOnClickListener {
            isUpdating = true
            etCelsius.text.clear()
            etFahrenheit.text.clear()
            etKelvin.text.clear()
            isUpdating = false
        }
    }
}