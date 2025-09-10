package com.tejaretnou.aiassistant.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.R

class MainActivity : AppCompatActivity() {
    
    companion object {
        private const val TAG = "MainActivity"
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "🔵 onCreate() شروع شد")
        
        try {
            super.onCreate(savedInstanceState)
            Log.d(TAG, "✅ super.onCreate() موفق")
            
            setContentView(R.layout.activity_main)
            Log.d(TAG, "✅ setContentView() موفق")
            
            setupButtons()
            Log.d(TAG, "✅ setupButtons() موفق")
            
            Toast.makeText(this, "🎉 برنامه اجرا شد!", Toast.LENGTH_LONG).show()
            Log.d(TAG, "✅ Toast نمایش داده شد")
            
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onCreate(): ${e.message}", e)
            try {
                Toast.makeText(this, "خطا: ${e.message}", Toast.LENGTH_LONG).show()
            } catch (toastError: Exception) {
                Log.e(TAG, "❌ حتی Toast هم کار نمی‌کند: ${toastError.message}")
            }
        }
    }
    
    private fun setupButtons() {
        try {
            Log.d(TAG, "🔵 تنظیم دکمه‌ها...")
            
            val btnOnline = findViewById<Button>(R.id.btn_online)
            val btnOffline = findViewById<Button>(R.id.btn_offline)  
            val btnSettings = findViewById<Button>(R.id.btn_settings)
            
            Log.d(TAG, "دکمه‌ها پیدا شدند: online=${btnOnline != null}, offline=${btnOffline != null}, settings=${btnSettings != null}")
            
            btnOnline?.setOnClickListener {
                Log.d(TAG, "✅ دکمه آنلاین کلیک شد")
                Toast.makeText(this, "🟢 حالت آنلاین", Toast.LENGTH_SHORT).show()
            }
            
            btnOffline?.setOnClickListener {
                Log.d(TAG, "✅ دکمه آفلاین کلیک شد")
                Toast.makeText(this, "🔵 حالت آفلاین", Toast.LENGTH_SHORT).show()
            }
            
            btnSettings?.setOnClickListener {
                Log.d(TAG, "✅ دکمه تنظیمات کلیک شد")
                Toast.makeText(this, "⚙️ تنظیمات", Toast.LENGTH_SHORT).show()
            }
            
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در setupButtons(): ${e.message}", e)
        }
    }
    
    override fun onStart() {
        Log.d(TAG, "🔵 onStart() شروع شد")
        try {
            super.onStart()
            Log.d(TAG, "✅ onStart() موفق")
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onStart(): ${e.message}", e)
        }
    }
    
    override fun onResume() {
        Log.d(TAG, "🔵 onResume() شروع شد")
        try {
            super.onResume()
            Log.d(TAG, "✅ onResume() موفق - برنامه کاملاً آماده است")
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onResume(): ${e.message}", e)
        }
    }
    
    override fun onPause() {
        Log.d(TAG, "🔵 onPause() شروع شد")
        try {
            super.onPause()
            Log.d(TAG, "✅ onPause() موفق")
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onPause(): ${e.message}", e)
        }
    }
    
    override fun onStop() {
        Log.d(TAG, "🔵 onStop() شروع شد")
        try {
            super.onStop()
            Log.d(TAG, "✅ onStop() موفق")
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onStop(): ${e.message}", e)
        }
    }
    
    override fun onDestroy() {
        Log.d(TAG, "🔵 onDestroy() شروع شد")
        try {
            super.onDestroy()
            Log.d(TAG, "✅ onDestroy() موفق")
        } catch (e: Exception) {
            Log.e(TAG, "❌ خطا در onDestroy(): ${e.message}", e)
        }
    }
}
