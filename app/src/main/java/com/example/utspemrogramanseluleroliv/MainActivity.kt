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
        setContentView(R.layout.activity_main)

        val inputNamaDosen = findViewById<EditText>(R.id.inputNamaDosen)
        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            val namaDosen = inputNamaDosen.text.toString().trim()

            if (namaDosen.isEmpty()) {
                Toast.makeText(this, "Nama Dosen wajib diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pindah halaman dan mengirim data
            val intent = Intent(this, PanelActivity::class.java).apply {
                putExtra("NAMA_DOSEN", namaDosen)
            }
            startActivity(intent)
        }
    }
}