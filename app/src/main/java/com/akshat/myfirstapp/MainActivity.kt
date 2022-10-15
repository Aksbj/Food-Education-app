package com.akshat.myfirstapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnSteve:Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnThor:Button
    lateinit var btnHulk:Button
    lateinit var btnBlack:Button
    lateinit var exit:Button
    var titleName: String? = "Avengers"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scroll_view_avengers)
        titleName=sharedPreferences.getString("Title","Avengers")
        title=titleName
        btnSteve=findViewById(R.id.btnSteve)
        btnThor=findViewById(R.id.btnThor)
        btnHulk=findViewById(R.id.btnHulk)
        btnBlack=findViewById(R.id.btnBlack)
        exit=findViewById(R.id.exit)
        btnSteve.setOnClickListener{
            Toast.makeText(this@MainActivity,"Showing Details",Toast.LENGTH_SHORT).show()
            val intent= Intent(this@MainActivity,MessageActivity::class.java)
            startActivity(intent)
        }
        btnThor.setOnClickListener{
            Toast.makeText(this@MainActivity,"Showing Details",Toast.LENGTH_SHORT).show()
            val intent= Intent(this@MainActivity,Description::class.java)
            startActivity(intent)
        }
        btnHulk.setOnClickListener{
            Toast.makeText(this@MainActivity,"Showing Details",Toast.LENGTH_SHORT).show()
            val intent= Intent(this@MainActivity,Description2::class.java)
            startActivity(intent)
        }
        btnBlack.setOnClickListener{
            Toast.makeText(this@MainActivity,"Showing Details",Toast.LENGTH_SHORT).show()
            val intent= Intent(this@MainActivity,Description3::class.java)
            startActivity(intent)
        }
        exit.setOnClickListener{
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            sharedPreferences.edit().clear().apply()
            finish()
        }
    }
}
