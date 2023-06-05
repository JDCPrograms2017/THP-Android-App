package com.example.tazlinaheartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class MainActivity : AppCompatActivity() {

    private lateinit var OnBtn: Button
    private lateinit var OffBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        OnBtn = findViewById(R.id.OnButton)
        OffBtn = findViewById(R.id.OffButton)

        OnBtn.setOnClickListener {
            val resp: String = sendHTTPRequest("on")
        }
    }

    // Used to dynamically create buttons in a heart shape to display to the menu screen
    private fun generateHeartDisplay() {

    }

    // This will ensure that before we send our instructions, we are actually able to connect to the ESP32
    private fun sendHTTPRequest(req: String) : String {
        val HTTPClient = OkHttpClient()
        val request = Request.Builder().url("192.168.blah.blah/$req").build()
        val HTTPResponse: Response = HTTPClient.newCall(request).execute()
        return HTTPResponse.body?.string() ?: "" // Return an empty string if the response body is NULL
    }
}