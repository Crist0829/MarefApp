package com.example.marefgroup

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {

    var count = 1 //Sirve de auxiliar para el slice.
    var countLink = 1 // Sirve de auxiliar para abrir el link que redirige al aula virtual, productos o equipos

    override fun onCreate(savedInstanceState: Bundle?) {

        //--Cambia el theme al principal para que al inicio cargue el Splash.--//
        setTheme(R.style.Theme_AppCompat_DayNight_NoActionBar)
        //---------------------------------------------------//

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Listeners()

        /*//--Las dos vistas que llaman la función Slice que es la encargada de cambiar las imagen-----------//
        y los botones*/
        val imgslice = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.constraintLayout)
        val btnslice = findViewById<LinearLayout>(R.id.linearLayout)

        btnslice.setOnClickListener { slice(it) }
        imgslice.setOnClickListener { slice(it) }
        //----------------------------------------//

        val settingsButton : Button = findViewById(R.id.settings)

        settingsButton.setOnClickListener{

            val setting : Intent = Intent(this, Settings::class.java)
            startActivity(setting)

        }

        var han = Handler()

        fun sliceRepeat(){

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

                    countLink = 1
                    count ++

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

                    countLink = 2
                    count ++


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

                    countLink = 3
                    count = 1

                }


            }


        }

        val repetir = Thread(Runnable {

            while (true){

                try {

                    Thread.sleep(2800)

                }catch (e : InterruptedException){

                    e.printStackTrace()

                }

                han.post(Runnable {

                    sliceRepeat()

                })

            }

        })
        repetir.start()


    }

    // Esta funcion es la encargada de cambiar las imagenes "fondos" del slice
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

                countLink = 1

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

                countLink = 2


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

               countLink = 3


        }


        }

        if(count == 3){

            count = 1

        }else{

            count ++
        }

    }

    //Los eventos de los botones principales
    fun Listeners(){

        val cronometro : ImageButton = findViewById(R.id.cronometro)
        val calculos : ImageButton = findViewById(R.id.calculos)
        val catalogo : ImageButton = findViewById(R.id.catalogo)
        val contacto : ImageButton= findViewById(R.id.contacto)
        val botonImagen : TextView = findViewById(R.id.botones_imagen)

        val listaBotones = listOf<View>(cronometro, calculos, catalogo, contacto, botonImagen)

        for (boton in listaBotones){

            boton.setOnClickListener{ cambiarActivity(it) }

        }

    }

    //Cambia de activity dependiendo el botón presionado, usando el ID.
    fun cambiarActivity(view : View){

        when(view.id){

            R.id.cronometro -> {

                val cambiar : Intent = Intent(this, Cronometro::class.java)
                startActivity(cambiar)

            }
            R.id.calculos -> {

                val cambiar : Intent = Intent(this, Calculos::class.java)
                startActivity(cambiar)

            }
            R.id.catalogo -> {

                val uri : Uri = Uri.parse("https://maref.com.ar/productos/")
                val intent : Intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)

            }
            R.id.contacto -> {

                val cambiar : Intent = Intent(this, Contacto::class.java)
                startActivity(cambiar)
            }

            R.id.botones_imagen -> {

                when(countLink){

                    1-> {

                        val uri : Uri = Uri.parse("https://maref.com.ar/courses/")
                        val intent : Intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)

                    }

                    2-> {

                        val uri : Uri = Uri.parse("https://maref.com.ar/equipos/")
                        val intent : Intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)

                    }

                    3-> {

                        val uri : Uri = Uri.parse("https://maref.com.ar/productos/")
                        val intent : Intent = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(intent)

                    }


                }


            }


        }

    }


}