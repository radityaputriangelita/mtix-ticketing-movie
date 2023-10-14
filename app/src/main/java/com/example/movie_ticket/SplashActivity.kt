package com.example.movie_ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.movie_ticket.databinding.ActivityMainBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val SPLASH_DISPLAY_LENGTH = 4000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            Handler().postDelayed({
                val IntentToMainActivity = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(IntentToMainActivity)
                finish()
            }, SPLASH_DISPLAY_LENGTH.toLong())
        }


    }
}