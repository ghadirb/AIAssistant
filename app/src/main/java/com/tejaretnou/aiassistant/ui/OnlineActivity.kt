package com.tejaretnou.aiassistant.ui

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tejaretnou.aiassistant.R
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class OnlineActivity : AppCompatActivity() {

    private lateinit var edtApiKey: EditText
    private lateinit var edtPrompt: EditText
    private lateinit var txtResponse: TextView
    private lateinit var spinnerModels: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_online)

        edtApiKey = findViewById(R.id.edt_api_key)
        edtPrompt = findViewById(R.id.edt_prompt)
        txtResponse = findViewById(R.id.txt_response)
        spinnerModels = findViewById(R.id.spinner_models)

        val btnSend = findViewById<Button>(R.id.btn_send_prompt)

        // مدل‌های قابل انتخاب
        val models = arrayOf("gpt-4o-mini", "gpt-4o", "claude-3-haiku")
        spinnerModels.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, models)

        btnSend.setOnClickListener {
            val apiKey = edtApiKey.text.toString()
            val prompt = edtPrompt.text.toString()
            val model = spinnerModels.selectedItem.toString()

            if (apiKey.isE
