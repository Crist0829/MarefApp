package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat

class Settings : AppCompatActivity() {
    var count = 0
    var count2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        listeners()
        val homeButton : Button = findViewById(R.id.home)
        val backButton : Button = findViewById(R.id.backButton)
        
        backButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }
        homeButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }

    }

    fun listeners(){
        val ayuda : TextView = findViewById(R.id.ayudaTitulo)
        val actual : TextView = findViewById(R.id.actualizacionesTitulo)

        val botonera = listOf<View>(ayuda, actual)

        for (boton in botonera){

            boton.setOnClickListener{

                acordion(it)

            }

        }



    }

    fun acordion(view : View){

        when(view.id){

            R.id.ayudaTitulo->{

                if(count == 0){

                    val ubicacion : TextView = findViewById(R.id.ayudaContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_down)
                    val ayuda = findViewById<TextView>(R.id.ayudaTitulo)
                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }
                    ayuda.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.VISIBLE
                    count = 1

                }else{

                    val ubicacion : TextView = findViewById(R.id.ayudaContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_right)
                    val ayuda = findViewById<TextView>(R.id.ayudaTitulo)

                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }

                    ayuda.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.GONE
                    count = 0

                }

            }

            R.id.actualizacionesTitulo->{

                if(count2 == 0){

                    val ubicacion : TextView = findViewById(R.id.actualizacionContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_down)
                    val actual = findViewById<TextView>(R.id.actualizacionesTitulo)
                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }
                    actual.setCompoundDrawables(icono, null, null, null)
                    ubicacion.visibility = View.VISIBLE
                    count2 = 1

                }else{

                    val contenido : TextView = findViewById(R.id.actualizacionContenido)
                    val icono = ContextCompat.getDrawable(this, R.drawable.arrow_right)
                    val actual = findViewById<TextView>(R.id.actualizacionesTitulo)

                    if (icono != null) {
                        icono.setBounds(0, 0, 36, 36)
                    }

                    actual.setCompoundDrawables(icono, null, null, null)
                    contenido.visibility = View.GONE
                    count2 = 0

                }

            }


        }


    }
}