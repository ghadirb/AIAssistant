package com.tejaretnou.aiassistant.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.btnOnline.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java).apply {
                putExtra("mode", "online")
            })
        }

        binding.btnOffline.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java).apply {
                putExtra("mode", "offline")
            })
        }

        binding.btnSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
