package com.example.utspemrogramanseluleroliv

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val inputJmlMhs = findViewById<EditText>(R.id.inputJmlMhs)
        val inputRataRata = findViewById<EditText>(R.id.inputRataRata)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val tvDaftarAbsen = findViewById<TextView>(R.id.tvDaftarAbsen)

        val namaDosen = intent.getStringExtra("NAMA_DOSEN") ?: "Tanpa Nama"
        tvSapaan.text = "Selamat bertugas, Dosen $namaDosen"

        btnProses.setOnClickListener {
            val strJmlMhs = inputJmlMhs.text.toString().trim()
            val strRataRata = inputRataRata.text.toString().trim()

            if (strJmlMhs.isEmpty() || strRataRata.isEmpty()) {
                Toast.makeText(this, "Harap lengkapi semua data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jmlMhs = strJmlMhs.toIntOrNull() ?: 0
            val rataRata = strRataRata.toDoubleOrNull() ?: 0.0

            // Logika If-Else untuk menentukan status
            val statusKelas: String
            val warnaStatus: Int

            if (rataRata >= 80) {
                statusKelas = "Sangat Baik"
                warnaStatus = android.graphics.Color.parseColor("#27AE60") // Hijau
            } else if (rataRata >= 60) {
                statusKelas = "Cukup"
                warnaStatus = android.graphics.Color.parseColor("#F39C12") // Orange
            } else {
                statusKelas = "Kurang"
                warnaStatus = android.graphics.Color.parseColor("#C62828") // Merah
            }

            tvStatus.text = "Status Kelas: $statusKelas"
            tvStatus.setTextColor(warnaStatus)

            // Logika Perulangan For
            val teksDaftarAbsen = buildString {
                for (i in 1..jmlMhs) {
                    append("✓ Mahasiswa $i:\n    Nama: __________________\n    Nilai : ______\n\n")
                }
            }
            tvDaftarAbsen.text = teksDaftarAbsen
        }
    }
}