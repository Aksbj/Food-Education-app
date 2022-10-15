package com.akshat.myfirstapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){
    lateinit var etMob:EditText
    lateinit var etPass:EditText
    lateinit var btnLogIn:Button
    lateinit var txtRegister:TextView
    val validMobileNumber="1234567899"
    val validPassword= arrayOf("steve","thor","bruce","black")
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            var intent=Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"
        etMob = findViewById(R.id.etMob)
        etPass = findViewById(R.id.etPass)
        btnLogIn = findViewById(R.id.btnLogIn)
        txtRegister = findViewById(R.id.txtRegister)
        btnLogIn.setOnClickListener { val mobileNumber = etMob.text.toString()
            val password = etPass.text.toString()
            var nameOfAvenger="Avenger"
            val intent = Intent(this@LoginActivity, MainActivity::class.java)
            if ((mobileNumber == validMobileNumber)) {
                if(password==validPassword[0]){
                    nameOfAvenger="CaptainAmerica"
                    savedPreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }else if(password==validPassword[1]){
                    nameOfAvenger="Thor"
                    savedPreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }else if(password==validPassword[2]){
                    nameOfAvenger="Hulk"
                    savedPreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }else if(password==validPassword[3]){
                    nameOfAvenger="BlackWidow"
                    savedPreferences(nameOfAvenger)
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
        }else{
                Toast.makeText(this@LoginActivity,"Incorrect Credentials",Toast.LENGTH_SHORT).show()}
        }
        txtRegister.setOnClickListener{Toast.makeText(this@LoginActivity,"Registration",Toast.LENGTH_SHORT).show()
            val intent= Intent(this@LoginActivity,Register::class.java)
            startActivity(intent)}
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savedPreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }

}
