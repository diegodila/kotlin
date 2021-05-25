package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a = findViewById<TextView>(R.id.text_1)
        a.text = "2020-04-30"

        gotoMainActivity2()
    }

    private fun gotoMainActivity2() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent) },2000)

    }


}