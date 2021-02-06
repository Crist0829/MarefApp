package com.example.marefgroup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView

import android.widget.Toast
import java.lang.Exception
import kotlin.concurrent.thread

class Cronometro : AppCompatActivity() {

    //Variables auxiliares para funcionalidad del cronómetro
    var isRun = false
    var isStop = false
    var aux = ""
    var auxContPause = 0 // Contador para el botón de pauses
    var auxPlay = true //
    var auxPlayPause = false
    var auxStop = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cronometro)

        val backButton : Button = findViewById(R.id.backButton)
        backButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }

        //Componentes del cronómetro:
        var crono : TextView = findViewById(R.id.cronobody)
        val cronometro2 : TextView = findViewById(R.id.cronobody2)
        val cronometro3 : TextView = findViewById(R.id.cronobody3)
        val cronometro4 : TextView = findViewById(R.id.cronobody4)
        var mil = 0
        var seg = 0
        var min = 0
        var man = Handler()

        /*Esta funcion evaula los milisegundos, segundos y minustos que se le pasan
        * con variables por los parametros y devuelve un string agregando ceros si es necesario*/
        fun devZeros(mil : Int, seg : Int, min : Int ): String {

            var auxMil = ""
            var auxSeg = ""
            var auxMin = ""
            var auxRet = ""

            if(mil < 100) {

                if(mil < 10){

                    auxMil = "00" + mil.toString()

                }else{

                    auxMil = "0" + mil.toString()

                }


            }else{

                auxMil = mil.toString()

            }


            if(seg < 10){

                if(seg == 0){

                    auxSeg = "00"

                }

                auxSeg = "0" + seg.toString()

            }else{

                auxSeg = seg.toString()

            }

            if(min < 10){

                if(min == 0){

                    auxMin = "00"

                }

                auxMin = "0" + min.toString()

            }else{

                auxMin = min.toString()

            }

            auxRet = auxMin + ":" + auxSeg + ":" + auxMil

            return auxRet

        }

        val cronometro = Thread(Runnable {

            while(true){

                if(isRun){

                    try {

                        Thread.sleep(1)

                    }catch (e : InterruptedException){

                        e.printStackTrace()

                    }

                    mil ++

                    if(mil == 999){

                        seg ++
                        mil = 0

                    }

                    if(seg == 59){

                        min ++
                        seg = 0

                    }

                    man.post(Runnable {

                        aux = devZeros(mil, seg, min)
                        crono.text = aux


                    })

                    }

                if(isStop){

                    try {

                        Thread.sleep(1)

                    }catch (e : InterruptedException){

                        e.printStackTrace()

                    }

                    mil ++

                    if(mil == 999){

                        seg ++
                        mil = 0

                    }

                    if(seg == 59){

                        min ++
                        seg = 0

                    }

                    man.post(Runnable {

                        min = 0
                        seg = 0
                        mil = 0
                        aux = "00:00:00"
                        crono.text = "00:00:00"


                    })

                }

                }

        })

        cronometro.start()

        //Botones:
        fun actionBotones(view : View){

            when(view.id){

                R.id.play->{

                    isRun = true
                    isStop = false
                    auxStop = false

                }

                R.id.stop->{

                    if(auxStop){

                        val cronometro2 : TextView = findViewById(R.id.cronobody2)
                        val cronometro3 : TextView = findViewById(R.id.cronobody3)
                        val cronometro4 : TextView = findViewById(R.id.cronobody4)

                        cronometro2.text = "00:00:00"
                        cronometro3.text = "00:00:00"
                        cronometro4.text = "00:00:00"

                        auxStop = false

                    }

                    isStop = true
                    isRun = false
                    auxStop = true

                }

                R.id.pause->{

                    if(cronometro2.text.equals("00:00:00") || crono.text.equals("00:00:00")){

                        auxContPause = 0

                    }

                    when(auxContPause){

                        0->{
                            val aux2 = aux
                            cronometro2.text = aux2
                            crono.text = cronometro2.text
                            auxContPause ++

                        }

                        1->{

                            cronometro3.text = aux
                            crono.text = cronometro3.text
                            auxContPause ++

                        }

                        2->{

                            cronometro4.text = aux
                            crono.text = cronometro4.text
                            auxContPause = 0

                        }


                    }

                }

            }

        }

        fun listeners(){

            val play : com.google.android.material.floatingactionbutton.FloatingActionButton = findViewById(R.id.play)
            val pause : com.google.android.material.floatingactionbutton.FloatingActionButton = findViewById(R.id.pause)
            val stop : com.google.android.material.floatingactionbutton.FloatingActionButton = findViewById(R.id.stop)

            val botones = listOf<View>(play, pause, stop)

            for (boton in botones){

                boton.setOnClickListener({ actionBotones(it)})

            }

        }

        listeners()

        }

}
