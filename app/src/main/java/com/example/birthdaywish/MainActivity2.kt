package com.example.birthdaywish

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val nameInput = findViewById<EditText>(R.id.name)
        val dobInput = findViewById<EditText>(R.id.dob)
        val submitButton = findViewById<Button>(R.id.btn)


        submitButton.setOnClickListener { v: View? ->
            val name = nameInput.text.toString().trim { it <= ' ' }
            val dob = dobInput.text.toString().trim { it <= ' ' }
            if (name.isEmpty() || dob.isEmpty()) {
                Toast.makeText(
                    this@MainActivity2,
                    "Please enter all details",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val intent =
                    Intent(
                        this@MainActivity2,
                        MainActivity3::class.java
                    )
                intent.putExtra("name", name)
                intent.putExtra("dob", dob)
                startActivity(intent)
            }
        }

    }
}