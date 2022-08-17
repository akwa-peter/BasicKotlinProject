package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the views
        val txtHello = findViewById<TextView>(R.id.txtHello)
        val edtName = findViewById<EditText>(R.id.edtName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnOffers = findViewById<Button>(R.id.btnOffers)

        //Initialize name variable
        var name = ""

        //Show entered name on button click
        btnSubmit.setOnClickListener {
            name = edtName.text.toString()

            if (name.isEmpty()){
                //Show offers button
                btnOffers.visibility = INVISIBLE

                //Clear the hello text
                txtHello.text = ""

                //Show enter name toast
                Toast.makeText(
                    this@MainActivity,
                    "Please enter your name",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                val message = "Welcome $name"
                txtHello.text = message
                edtName.text.clear()
                btnOffers.visibility = VISIBLE
            }
        }

        //Launch second activity
        btnOffers.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("USER", name)
            startActivity(intent)
        }
    }
}