package com.example.movie_ticket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie_ticket.databinding.ActivityFifthBinding
import com.example.movie_ticket.databinding.ActivitySecondBinding

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val place=intent.getStringExtra(FourthActivity.EXTRA_PLACE)

        with(binding){
            MoviePlace.text = place
        }

    }
}