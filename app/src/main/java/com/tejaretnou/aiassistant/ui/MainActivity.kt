package com.tejaretnou.aiassistant.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.R

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // نمایش پیغام برای تست
        Toast.makeText(this, "برنامه با موفقیت اجرا شد!", Toast.LENGTH_LONG).show()
        println("✅ برنامه اجرا شد!")
    }
    
    override fun onStart() {
        super.onStart()
        println("✅ Activity started")
    }
    
    override fun onResume() {
        super.onResume()
        println("✅ Activity resumed")
    }
}
