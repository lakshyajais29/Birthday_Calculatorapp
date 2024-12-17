package com.example.birthdaywish

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Get references to TextViews
        val cardName = findViewById<TextView>(R.id.card_name)
        val cardAge = findViewById<TextView>(R.id.card_age)
        val cardDaysLeft = findViewById<TextView>(R.id.card_days_left)

        // Get data from Intent
        val name = intent.getStringExtra("name")
        val dobString = intent.getStringExtra("dob")

        try {
            // Parse Date of Birth
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val dob = sdf.parse(dobString)

            // Get current date and year
            val today = Calendar.getInstance()
            val dobCal = Calendar.getInstance()
            dobCal.time = dob

            // Calculate Age
            var age = today[Calendar.YEAR] - dobCal[Calendar.YEAR]
            if (today[Calendar.DAY_OF_YEAR] < dobCal[Calendar.DAY_OF_YEAR]) {
                age--
            }

            // Calculate Days Left for Next Birthday
            dobCal[Calendar.YEAR] = today[Calendar.YEAR]
            if (dobCal.before(today)) {
                dobCal.add(Calendar.YEAR, 1)
            }
            val diffInMillis = dobCal.timeInMillis - today.timeInMillis
            val daysLeft = diffInMillis / (1000 * 60 * 60 * 24)

            // Set data to CardView
            cardName.text = "Name: $name"
            cardAge.text = "Age: $age"
            cardDaysLeft.text = "Days left for next birthday: $daysLeft"
        } catch (e: Exception) {
            e.printStackTrace()
            cardName.text = "Invalid date format"
        }
    }
}