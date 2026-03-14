package com.example.utspemrogramanseluleroliv

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PanelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_panel) // Pastikan nama file layout Anda benar

        // 1. Hubungkan dengan ID baru dari XML
        val detailKelas = findViewById<TextView>(R.id.teksDetailKelas)
        val daftarAbsen = findViewById<TextView>(R.id.teksListAbsen)

        // 2. Ambil data dari Intent menggunakan KUNCI yang sudah diubah di MainActivity
        val namaPengajar = intent.getStringExtra("KUNCI_DOSEN") ?: "Tidak diketahui"
        val namaPelajaran = intent.getStringExtra("KUNCI_MATKUL") ?: "Tidak diketahui"
        val teksTotalMhs = intent.getStringExtra("KUNCI_TOTAL")

        // Konversi ke angka secara aman (jika kosong/bukan angka, otomatis jadi 0)
        val totalMahasiswa = teksTotalMhs?.toIntOrNull() ?: 0

        // 3. Logika penentuan status (Gaya penulisan Kotlin yang ringkas)
        val statusKapasitas = if (totalMahasiswa > 30) "Kelas Besar" else "Kelas Reguler"

        // 4. Tampilkan info kelas menggunakan Multiline String agar kode lebih bersih
        val rangkumanInfo = """
            Pengajar   : $namaPengajar
            Pelajaran  : $namaPelajaran
            Tipe Kelas : $statusKapasitas
        """.trimIndent()

        detailKelas.text = rangkumanInfo

        // 5. Perulangan For menggunakan buildString (lebih optimal dari += untuk performa)
        val hasilGenerate = buildString {
            for (nomor in 1..totalMahasiswa) {
                append("$nomor. Nama Mhs: __________________ | Skor: _____ \n\n")
            }
        }

        daftarAbsen.text = hasilGenerate
    }
}