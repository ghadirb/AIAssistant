package com.tejaretnou.aiassistant.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.tejaretnou.aiassistant.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOffline = findViewById<Button>(R.id.btn_offline)
        val btnOnline = findViewById<Button>(R.id.btn_online)
        val btnSettings = findViewById<Button>(R.id.btn_settings)

        btnOffline.setOnClickListener {
            startActivity(Intent(this, OfflineActivity::class.java))
        }

        btnOnline.setOnClickListener {
            startActivity(Intent(this, OnlineActivity::class.java))
        }

        btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
