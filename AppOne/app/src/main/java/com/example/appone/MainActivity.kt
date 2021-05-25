package com.example.appone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constraintLayout = findViewById(R.id.constraintLayout) as ConstraintLayout

        val listView = ListView(this)

        val values = arrayOf(
                "Rick and Morty",
                "Gaeme of Thrones",
                "Silicon Valley",
                "IT Crowd",
                "Person of Interest")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values)

        listView.adapter = adapter

        fun sendMessage(view: View) {

        }

        constraintLayout.addView(listView)
    }
}
