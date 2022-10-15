package com.akshat.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Register : AppCompatActivity() {
    lateinit var registration: TextView
    lateinit var full: EditText
    lateinit var mobile: EditText
    lateinit var password: EditText
    lateinit var reg: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registration=findViewById(R.id.registration)
        full=findViewById(R.id.full)
        mobile=findViewById(R.id.mobile)
        password=findViewById(R.id.password)
        reg=findViewById(R.id.reg)
        reg.setOnClickListener {
            Toast.makeText(this@Register,"Successfully Registered", Toast.LENGTH_SHORT).show()
            val intent= Intent(this@Register,MainActivity::class.java)
            startActivity(intent)
        }
    }
}