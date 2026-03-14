package com.example.utspemrogramanseluleroliv

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Pastikan nama file XML kamu benar-benar 'activity_main.xml'
        setContentView(R.layout.activity_main)

        // PERBAIKAN: ID sekarang sudah disamakan dengan yang ada di activity_main.xml
        val kolomDosen = findViewById<EditText>(R.id.inputDosen)
        val kolomMatkul = findViewById<EditText>(R.id.inputMatkul)
        val kolomTotalMhs = findViewById<EditText>(R.id.inputJmlMhs)
        val tombolAksi = findViewById<Button>(R.id.tombolProses)

        tombolAksi.setOnClickListener {
            // Mengambil teks dan membuang spasi kosong di awal/akhir kata dengan trim()
            val pengajar = kolomDosen.text.toString().trim()
            val pelajaran = kolomMatkul.text.toString().trim()
            val teksJmlMhs = kolomTotalMhs.text.toString().trim()

            // Logika pengecekan: Jika ada salah satu yang kosong, tampilkan pesan peringatan
            if (pengajar.isBlank() || pelajaran.isBlank() || teksJmlMhs.isBlank()) {
                Toast.makeText(this, "Harap isi semua form terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Menghentikan proses agar tidak lanjut ke bawah
            }

            // Membungkus dan mengirim data menggunakan 'apply' agar penulisan lebih rapi
            val navigasiIntent = Intent(this, PanelActivity::class.java).apply {
                putExtra("KUNCI_DOSEN", pengajar)
                putExtra("KUNCI_MATKUL", pelajaran)
                putExtra("KUNCI_TOTAL", teksJmlMhs)
            }

            startActivity(navigasiIntent)
        }
    }
}