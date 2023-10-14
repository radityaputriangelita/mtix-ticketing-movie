package com.example.movie_ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.example.movie_ticket.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView: WebView = binding.webView

        val video: String = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/qEVUtrk8_B4?si=i8VI_s6ld-1FM2yB\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video, "text/html", "utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()
        with(binding){
            btnOrders.setOnClickListener {
                val intentToFourthActivity = Intent(this@ThirdActivity, FourthActivity::class.java)
                startActivity(intentToFourthActivity)
            }

            btnBack.setOnClickListener {
                val intentToSecondActivity = Intent(this@ThirdActivity, SecondActivity::class.java)
                startActivity(intentToSecondActivity)
            }
        }
    }
}
