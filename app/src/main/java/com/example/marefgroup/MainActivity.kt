package com.example.marefgroup

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.LinearLayout

import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    var count = 1;

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Listeners()

        val imgslice = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.constraintLayout)
        val btnslice = findViewById<LinearLayout>(R.id.linearLayout)

        btnslice.setOnClickListener { slice(it) }
        imgslice.setOnClickListener { slice(it) }


    }

    fun slice(view : View){

        when(count){



            1-> {
                val imagen = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.constraintLayout)
                val boton = findViewById<TextView>(R.id.botones_imagen)
                val texto = findViewById<TextView>(R.id.texto_imagenes)

                val navButton1 = findViewById<Button>(R.id.nav_button1)
                val navButton2 = findViewById<Button>(R.id.nav_button2)
                val navButton3 = findViewById<Button>(R.id.nav_button3)

                boton.text = "Aula Virtual"
                imagen.setBackgroundResource(R.drawable.img1)
                texto.setText(R.string.capacitaciones)
                navButton1.setBackgroundResource(R.drawable.circle01)
                navButton2.setBackgroundResource(R.drawable.circle02)
                navButton3.setBackgroundResource(R.drawable.circle02)

            }

            2-> {

                val imagen = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.constraintLayout)
                val texto = findViewById<TextView>(R.id.texto_imagenes)
                val boton = findViewById<TextView>(R.id.botones_imagen)
                imagen.setBackgroundResource(R.drawable.img2)


                val navButton1 = findViewById<Button>(R.id.nav_button1)
                val navButton2 = findViewById<Button>(R.id.nav_button2)
                val navButton3 = findViewById<Button>(R.id.nav_button3)

                boton.text = "EQUIPOS"
                texto.setText(R.string.aditivos)

                navButton1.setBackgroundResource(R.drawable.circle02)
                navButton2.setBackgroundResource(R.drawable.circle01)
                navButton3.setBackgroundResource(R.drawable.circle02)


            }

           3 -> {

                val imagen = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.constraintLayout)
                val texto = findViewById<TextView>(R.id.texto_imagenes)
                val boton = findViewById<TextView>(R.id.botones_imagen)

               val navButton1 = findViewById<Button>(R.id.nav_button1)
               val navButton2 = findViewById<Button>(R.id.nav_button2)
               val navButton3 = findViewById<Button>(R.id.nav_button3)

                boton.text = "PRODUCTOS"
                imagen.setBackgroundResource(R.drawable.img3)
                texto.setText(R.string.equipos)


               navButton1.setBackgroundResource(R.drawable.circle02)
               navButton2.setBackgroundResource(R.drawable.circle02)
               navButton3.setBackgroundResource(R.drawable.circle01)


        }


        }

        if(count == 3){

            count = 0

        }else{

            count ++
        }

    }



    fun Listeners(){

        val cronometro : Button = findViewById(R.id.cronometro)
        val calculos : Button = findViewById(R.id.calculos)
        val catalogo : Button = findViewById(R.id.catalogo)
        val contacto : Button = findViewById(R.id.contacto)
        val settings : Button = findViewById(R.id.settings)
        val botonImagen : TextView = findViewById(R.id.botones_imagen)

        val listaBotones = listOf<View>(cronometro, calculos, catalogo, contacto, settings, botonImagen)

        for (boton in listaBotones){

            boton.setOnClickListener{ cambiarActivity(it) }

        }

    }

    fun cambiarActivity(view : View){

        when(view.id){

            R.id.cronometro -> {

                val cambiar : Intent = Intent(this, Cronometro::class.java)
                startActivity(cambiar)

            }
            R.id.calculos -> {

                Toast.makeText(this, "ESTAMOS TRABAJANDO EN ELLO :)" , Toast.LENGTH_SHORT).show()

            }
            R.id.catalogo -> {

                val cambiar : Intent = Intent(this, Catalogo::class.java)
                startActivity(cambiar)

            }
            R.id.contacto -> {

                val cambiar : Intent = Intent(this, Contacto::class.java)
                startActivity(cambiar)
            }
            R.id.settings -> {

                Toast.makeText(this, "ESTAMOS TRABAJANDO EN ELLO :)" , Toast.LENGTH_SHORT).show()

            }

            R.id.botones_imagen -> {

                val uri : Uri = Uri.parse("https://maref.com.ar")
                val intent : Intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)

            }



        }

    }

}