package com.tejaretnou.aiassistant.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.tejaretnou.aiassistant.R

class OfflineActivity : AppCompatActivity() {

    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)

        statusText = findViewById(R.id.txt_status)

        val btnDownload = findViewById<Button>(R.id.btn_download_model)
        val btnStart = findViewById<Button>(R.id.btn_start_stt)
        val btnStop = findViewById<Button>(R.id.btn_stop_stt)

        btnDownload.setOnClickListener {
            Toast.makeText(this, "دانلود مدل (نمایشی)", Toast.LENGTH_SHORT).show()
            statusText.text = "مدل آماده است"
        }

        btnStart.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 101)
            } else {
                Toast.makeText(this, "شروع ضبط صوت (نمایشی)", Toast.LENGTH_SHORT).show()
                statusText.text = "در حال گوش دادن..."
                Log.d("OfflineActivity", "STT started")
                // TODO: ادغام با VoskRecognizer
            }
        }

        btnStop.setOnClickListener {
            Toast.makeText(this, "توقف ضبط", Toast.LENGTH_SHORT).show()
            statusText.text = "متوقف شد"
            Log.d("OfflineActivity", "STT stopped")
        }
    }
}
