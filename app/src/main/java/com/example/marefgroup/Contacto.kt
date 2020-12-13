package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class Contacto : AppCompatActivity() {
    var count = 0
    var count2 = 0
    var count3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)
        listeners()


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

    //Manejadores de eventos
    fun listeners(){
        val argentina : TextView = findViewById(R.id.argentinaTitulo)
        val chile : TextView = findViewById(R.id.chileTitulo)
        val peru : TextView = findViewById(R.id.peruTitulo)

        val botonera = listOf<View>(argentina, chile, peru)

        for(boton in botonera){

            boton.setOnClickListener{

                acordion(it)

            }

        }

    }

    //Funcion que hace que se despliegue y repliegue el acordion

    fun acordion(view : View){

        when(view.id){

            R.id.argentinaTitulo->{

                if(count == 0){

                    val ubicacion : TextView = findViewById(R.id.argentinaContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_down)
                    val argentina = findViewById<TextView>(R.id.argentinaTitulo)
                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }
                    argentina.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.VISIBLE
                    count = 1

                }else{

                    val ubicacion : TextView = findViewById(R.id.argentinaContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_right)
                    val argentina = findViewById<TextView>(R.id.argentinaTitulo)

                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }

                    argentina.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.GONE
                    count = 0

                }

            }

            R.id.chileTitulo->{

                if(count2 == 0){

                    val ubicacion : TextView = findViewById(R.id.chileContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_down)
                    val chile = findViewById<TextView>(R.id.chileTitulo)
                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }
                    chile.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.VISIBLE
                    count2 = 1

                }else{

                    val ubicacion : TextView = findViewById(R.id.chileContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_right)
                    val chile = findViewById<TextView>(R.id.chileTitulo)

                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }

                    chile.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.GONE
                    count2 = 0

                }

            }

            R.id.peruTitulo->{

                if(count3 == 0){

                    val ubicacion : TextView = findViewById(R.id.peruContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_down)
                    val peru = findViewById<TextView>(R.id.peruTitulo)
                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }
                    peru.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.VISIBLE
                    count3 = 1

                }else{

                    val ubicacion : TextView = findViewById(R.id.peruContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_right)
                    val peru = findViewById<TextView>(R.id.peruTitulo)

                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }

                    peru.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.GONE
                    count3 = 0

                }

            }


        }


    }

}