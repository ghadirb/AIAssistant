package com.tejaretnou.aiassistant.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.R
import com.tejaretnou.aiassistant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        // تست ساده
        binding.textView.text = "برنامه با موفقیت اجرا شد! 🎉"
    }
}
