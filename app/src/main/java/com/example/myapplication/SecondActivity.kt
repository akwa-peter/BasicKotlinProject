package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val name = intent.getStringExtra("USER")
        val txtName = findViewById<TextView>(R.id.txtUser)
        val message = "$name , you will get free access for all content for one month."
        txtName.text = message
    }
}