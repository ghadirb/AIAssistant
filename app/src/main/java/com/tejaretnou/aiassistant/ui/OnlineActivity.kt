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

            if (apiKey.isEmpty() || prompt.isEmpty()) {
                Toast.makeText(this, "کلید و متن لازم است", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            txtResponse.text = "در حال ارسال..."

            sendRequest(apiKey, model, prompt)
        }
    }

    private fun sendRequest(apiKey: String, model: String, prompt: String) {
        val client = OkHttpClient()

        val json = JSONObject()
        json.put("model", model)
        json.put("messages", listOf(mapOf("role" to "user", "content" to prompt)))

        val body = RequestBody.create(MediaType.parse("application/json"), json.toString())

        val request = Request.Builder()
            .url("https://api.openai.com/v1/chat/completions")
            .addHeader("Authorization", "Bearer $apiKey")
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    txtResponse.text = "خطا: ${e.message}"
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val res = response.body()?.string()
                runOnUiThread {
                    txtResponse.text = res ?: "پاسخی دریافت نشد"
                }
            }
        })
    }
}
