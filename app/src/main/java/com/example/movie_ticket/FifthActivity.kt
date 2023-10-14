package com.example.movie_ticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.movie_ticket.databinding.ActivityFifthBinding
import com.example.movie_ticket.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.Locale

class FifthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFifthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val place=intent.getStringExtra(FourthActivity.EXTRA_PLACE)
        val date=intent.getStringExtra(FourthActivity.EXTRA_DATE)
        val time=intent.getStringExtra(FourthActivity.EXTRA_TIME)
        val countseat=intent.getStringExtra(FourthActivity.EXTRA_JUMLAHKURSI)
        val typeseat=intent.getStringExtra(FourthActivity.EXTRA_JENISKURSI)
        val metodebayar=intent.getStringExtra(FourthActivity.EXTRA_METODEPEMBAYARAN)
        val pilihpembayaran = intent.getStringExtra(FourthActivity.EXTRA_PILIHANPEMBAYARAN)
        val totalamount = intent.getStringExtra(FourthActivity.EXTRA_TOTALBAYAR)
        val name = intent.getStringExtra(FourthActivity.EXTRA_USERNAME)

        //ga yakin pake ini karena bingung jelasinnya
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val dateObj = sdf.parse(date)
        val formattedDate = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(dateObj)

        with(binding){
            MoviePlace.text = place
            MovieDate.text = formattedDate
            MovieTime.text = time
            jumlahKursi.text = countseat
            jenisKursi.text = typeseat
            TicketPaymentMethod.text = metodebayar
            TicketCaraBayar.text = pilihpembayaran
            TicketTotalAmount.text = totalamount
            TicketUsername.text = name

            btnBack.setOnClickListener{
                val intentToFourthActivity = Intent (this@FifthActivity, FourthActivity::class.java)
                startActivity(intentToFourthActivity)
            }
        }

    }
}