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

        // Mengambil data dari MainActivity
        val namaDosen = intent.getStringExtra("NAMA_DOSEN") ?: "Tanpa Nama"
        tvSapaan.text = "Selamat bertugas, Dosen $namaDosen"

        btnProses.setOnClickListener {
            val strJmlMhs = inputJmlMhs.text.toString().trim()
            val strRataRata = inputRataRata.text.toString().trim()

            if (strJmlMhs.isEmpty() || strRataRata.isEmpty()) {
                Toast.makeText(this, "Harap isi jumlah mahasiswa dan rata-rata!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jmlMhs = strJmlMhs.toIntOrNull() ?: 0
            val rataRata = strRataRata.toDoubleOrNull() ?: 0.0

            // LOGIKA 1: If-Else untuk Status Kelas
            val statusKelas = if (rataRata >= 80) {
                "Sangat Baik"
            } else if (rataRata >= 60) {
                "Cukup"
            } else {
                "Kurang"
            }
            tvStatus.text = "Status Kelas: $statusKelas"

            // LOGIKA 2: Perulangan For untuk Daftar Absen
            val teksDaftarAbsen = buildString {
                for (i in 1..jmlMhs) {
                    append("Mahasiswa $i: __________________ \n")
                }
            }
            tvDaftarAbsen.text = teksDaftarAbsen
        }
    }
}