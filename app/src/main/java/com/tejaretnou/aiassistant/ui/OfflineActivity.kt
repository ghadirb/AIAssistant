package com.tejaretnou.aiassistant.ui

import android.Manifest
import android.content.pm.PackageManager
import android.media.AudioRecord
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.alphacephei.vosk.Recognizer
import com.alphacephei.vosk.Model
import com.alphacephei.vosk.android.SpeechService
import com.tejaretnou.aiassistant.R
import java.io.IOException

class OfflineActivity : AppCompatActivity() {

    private lateinit var statusText: TextView
    private lateinit var recordButton: Button

    private var model: Model? = null
    private var recognizer: Recognizer? = null
    private var speechService: SpeechService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offline)

        statusText = findViewById(R.id.txt_status)
        recordButton = findViewById(R.id.btn_record)

        // درخواست مجوز میکروفون
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECORD_AUDIO), 1)
        }

        try {
            // ⚠️ توجه: باید مدل vosk را در assets قرار دهی (مثلاً assets/models/vosk-model-small-en-us-0.15)
            model = Model("model") // مسیر پوشه مدل داخل assets یا storage
            recognizer = Recognizer(model, 16000.0f)
        } catch (e: IOException) {
            Log.e("OfflineActivity", "خطا در بارگذاری مدل: ${e.message}")
            Toast.makeText(this, "مدل آفلاین پیدا نشد", Toast.LENGTH_LONG).show()
        }

        // ضبط شبیه تلگرام (نگه‌دار → ضبط، رها کن → توقف)
        recordButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    startListening()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    stopListening()
                    true
                }
                else -> false
            }
        }
    }

    private fun startListening() {
        if (recognizer != null) {
            speechService = SpeechService(recognizer, 16000.0f)
            speechService?.startListening { result ->
                runOnUiThread {
                    statusText.text = result
                }
            }
            statusText.text = "🎤 در حال گوش دادن..."
        }
    }

    private fun stopListening() {
        speechService?.stop()
        speechService = null
        statusText.text = "⏹ ضبط متوقف شد"
    }
}
