package com.example.movie_ticket

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.movie_ticket.databinding.ActivityFourthBinding
import com.example.movie_ticket.databinding.ActivitySecondBinding
import com.example.movie_ticket.databinding.ActivityThirdBinding
import java.util.Calendar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val ListBioskop = resources.getStringArray(R.array.bioskop)
        val ListKursi = resources.getStringArray(R.array.kursi)
        val MetodeBayar = resources.getStringArray(R.array.metode_bayar)
        val ListBank = resources.getStringArray(R.array.Bank)

        with(binding) {
            val BioskopAdaptor = ArrayAdapter(
                this@FourthActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ListBioskop
            )
            val KursiAdaptor = ArrayAdapter(
                this@FourthActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ListKursi
            )
            val BayarAdaptor = ArrayAdapter(
                this@FourthActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                MetodeBayar
            )
            val BankAdaptor = ArrayAdapter(
                this@FourthActivity,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                ListBank
            )

            BioskopAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pilihanBioskop.adapter = BioskopAdaptor
            KursiAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            pilihanSeat.adapter = KursiAdaptor
            BayarAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            methodePembayaran.adapter = BayarAdaptor
            BankAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            bankPilihan.adapter = BankAdaptor

            buttonTgl.setOnClickListener {
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    this@FourthActivity,
                    DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                        mdy.setText("" + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year)
                    },
                    year,
                    month,
                    day
                )
                dpd.show()
            }

            buttonTime.setOnClickListener {
                val c = Calendar.getInstance()
                val hour = c.get(Calendar.HOUR_OF_DAY)
                val minute = c.get(Calendar.MINUTE)

                val timePickerDialog = TimePickerDialog(
                    this@FourthActivity,
                    TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
                        time.text = String.format("%02d:%02d", selectedHour, selectedMinute)
                    },
                    hour,
                    minute,
                    false
                )
                timePickerDialog.show()
            }

            val pilihanSeatSpinner = binding.pilihanSeat
            val hargaKursiTextView = binding.hargaKursi

            pilihanSeatSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val selectedSeat = ListKursi[position]
                        val harga: String = when (selectedSeat) {
                            "Reguler" -> "Rp35,000"
                            "Dobly Atmos" -> "Rp50,000"
                            "Imax" -> "Rp75,000"
                            "The Premiere" -> "Rp120,000"
                            else -> "Rp0"
                        }
                        hargaKursiTextView.text = harga
                    }
                    override fun onNothingSelected(parent: AdapterView<*>) {
                    }
                }
        }
    }
}

