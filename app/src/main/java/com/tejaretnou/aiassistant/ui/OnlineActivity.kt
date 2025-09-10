package com.tejaretnou.aiassistant.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.R

class OnlineActivity : AppCompatActivity() {

    private lateinit var edtApiKey: EditText
    private lateinit var edtPrompt: EditText
    private lateinit var txtResponse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online)

        edtApiKey = findViewById(R.id.edt_api_key)
        edtPrompt = findViewById(R.id.edt_prompt)
        txtResponse = findViewById(R.id.txt_response)

        val btnSend = findViewById<Button>(R.id.btn_send_prompt)

        btnSend.setOnClickListener {
            val apiKey = edtApiKey.text.toString()
            val prompt = edtPrompt.text.toString()

            if (apiKey.isEmpty() || prompt.isEmpty()) {
                Toast.makeText(this, "کلید و متن لازم است", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            txtResponse.text = "در حال ارسال..."
            // TODO: ادغام با LLM client واقعی
            Log.d("OnlineActivity", "Prompt: $prompt")
            txtResponse.text = "پاسخ نمایشی برای: $prompt"
        }
    }
}
