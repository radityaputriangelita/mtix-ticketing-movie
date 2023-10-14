package com.example.movie_ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.movie_ticket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_USERNAME = "extra_username"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btnLogin.setOnClickListener{
                val username = usernameInputEdittext.text.toString()
                val password = passwordInputEdittext.text.toString()

                if(username.length > 1 && !username.contains(" ") && password.length == 6 && password.isDigitsOnly() && username.all { it.isLetter()}){
                    val intentToSecondActivity = Intent(this@MainActivity, SecondActivity::class.java)
                    intentToSecondActivity.putExtra(EXTRA_USERNAME,usernameInputEdittext.text.toString())
                    startActivity(intentToSecondActivity)
                } else {
                    Toast.makeText(this@MainActivity, "Login Failed, Try Againn", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}