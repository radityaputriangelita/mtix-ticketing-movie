package com.example.movie_ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie_ticket.databinding.ActivityMainBinding
import com.example.movie_ticket.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        with(binding){
            welcomeUsername.text = username
            movie1.setOnClickListener{
                val intentToThirdActivity = Intent (this@SecondActivity, ThirdActivity::class.java)
                startActivity(intentToThirdActivity)
            }
        }
    }
}