package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Catalogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        val backButton : Button = findViewById(R.id.backButton)
        val homeButton : Button = findViewById(R.id.home)
        val settingsButton : Button = findViewById(R.id.settings)

        settingsButton.setOnClickListener{

            val setting : Intent = Intent(this, Settings::class.java)
            startActivity(setting)

        }

        homeButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }
        backButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }
    }
}