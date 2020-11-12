package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer

import android.widget.Toast

class Cronometro : AppCompatActivity() {

    lateinit var cronometro: Cronometro
    var runVar = false
    var stopVar : Long = 0
    var cont = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cronometro)
        val backButton : Button = findViewById(R.id.backButton)
        backButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }

    }

    fun cronometroAction(view : View){

        var cronometro : Chronometer = findViewById(R.id.cronobody)
        val cronometro2 : Chronometer = findViewById(R.id.cronobody2)
        val cronometro3 : Chronometer = findViewById(R.id.cronobody3)
        val cronometro4 : Chronometer = findViewById(R.id.cronobody4)


        when(view.id){

            R.id.play -> {

                if(!runVar){

                    cronometro.base = SystemClock.elapsedRealtime() - stopVar
                    cronometro.start()
                    runVar = true

                }

            }

            R.id.pause -> {

                when(cont){

                    0->{

                        if(runVar){

                            stopVar = SystemClock.elapsedRealtime() - cronometro.base
                            cronometro2.base = cronometro.base
                            cont ++

                        }

                    }

                    1->{

                        if(runVar){

                            stopVar = SystemClock.elapsedRealtime() - cronometro.base
                            cronometro3.base = cronometro.base
                            cont ++

                        }

                    }

                    2->{

                        if(runVar){

                            stopVar = SystemClock.elapsedRealtime() - cronometro.base
                            cronometro4.base = cronometro.base
                            cont = 0

                        }

                    }



                }



            }

            R.id.stop -> {

                cronometro.stop()
                cronometro.base = SystemClock.elapsedRealtime()
                runVar = false
                stopVar = 0
                cont = 0

            }

        }
    }

}