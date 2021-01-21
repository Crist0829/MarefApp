package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Calculos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculos)

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

        listeners()
    }

    fun listeners(){

        val volumen : Button = findViewById(R.id.volumenPozo)
        val volanular : Button = findViewById(R.id.volumenAnular)
        val velocidadAnularLodo : Button= findViewById(R.id.velocidadAnularLodo)
        val velocidadAnularAire : Button = findViewById(R.id.velocidadAnularAire)
        val tiemporetorno : Button = findViewById(R.id.tiempoRetorno)

        val bCalculos = listOf<View>(volumen, volanular, velocidadAnularLodo, velocidadAnularAire, tiemporetorno)


        for (boton in bCalculos){

            boton.setOnClickListener{ cambiarActivity(it) }

        }

    }

    fun cambiarActivity(view: View){

        when(view.id){

            R.id.volumenPozo->{

                val cambiar : Intent = Intent(this, volumenPozo::class.java)
                startActivity(cambiar)
            }

            R.id.volumenAnular -> {

                val cambiar : Intent = Intent(this, volumenAnular::class.java)
                startActivity(cambiar)

            }

            R.id.velocidadAnularLodo -> {

                val cambiar : Intent = Intent(this, velocidadAnularLodo::class.java)
                startActivity(cambiar)

            }

            R.id.velocidadAnularAire -> {

                val cambiar : Intent = Intent(this, velocidadAnularAire::class.java)
                startActivity(cambiar)

            }

            R.id.tiempoRetorno -> {

                val cambiar : Intent = Intent(this, tiempoRetorno::class.java)

                startActivity(cambiar)

            }



        }

    }
}