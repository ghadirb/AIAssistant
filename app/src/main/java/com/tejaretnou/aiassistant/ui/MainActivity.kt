package com.tejaretnou.aiassistant.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tejaretnou.aiassistant.R

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            Log.d(TAG, "Permission result: $isGranted")
            if (!isGranted) {
                Toast.makeText(this, "مجوز میکروفون لازم است", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_main)
            Log.d(TAG, "onCreate started")

            val btnOffline = findViewById<Button>(R.id.btn_offline)
            val btnSettings = findViewById<Button>(R.id.btn_settings)
            val btnOnline = findViewById<Button>(R.id.btn_online)

            btnOffline.setOnClickListener {
                Toast.makeText(this, "حالت آفلاین انتخاب شد", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Offline pressed")
                // TODO: صفحه حالت آفلاین
            }

            btnSettings.setOnClickListener {
                Toast.makeText(this, "تنظیمات باز شد", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Settings pressed")
                // TODO: صفحه تنظیمات
            }

            btnOnline.setOnClickListener {
                Toast.makeText(this, "حالت آنلاین انتخاب شد", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Online pressed")
                // TODO: صفحه حالت آنلاین
            }

            // درخواست مجوز میکروفون
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
            }

            Log.d(TAG, "onCreate completed")
        } catch (e: Exception) {
            Log.e(TAG, "خطا در onCreate(): ${e.message}", e)
        }
    }
}
