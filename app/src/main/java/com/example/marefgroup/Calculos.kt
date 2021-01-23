package com.example.marefgroup

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
        val porcentajesolidos : Button = findViewById(R.id.porcentajeSolidos)
        val volumentanquerect : Button = findViewById(R.id.volumenTanqueRectangular)
        val volumentanquecilindro : Button = findViewById(R.id.volumenTanqueCilindro)
        val caudalbombaduplex : Button = findViewById(R.id.caudalBombaBD)
        val caudalbombatriplex : Button = findViewById(R.id.caudalBombaBT)
        val reduccionsolidosdiso : Button = findViewById(R.id.reduccionSolidosDisolucion)
        val reduccionsolidosvol : Button = findViewById(R.id.reduccionSolidosVolcado)
        val densificacionbarita : Button = findViewById(R.id.densificacionBarita)
        val reducciondensidad : Button = findViewById((R.id.reduccionDensidad))
        val velocidadpenetracion : Button = findViewById(R.id.velocidadPenetracion)


        val bCalculos = listOf<View>(volumen, volanular, velocidadAnularLodo, velocidadAnularAire, tiemporetorno,
                                    porcentajesolidos, volumentanquerect, volumentanquecilindro, caudalbombaduplex,
                                    caudalbombatriplex, reduccionsolidosdiso, reduccionsolidosvol, densificacionbarita,
                                    reducciondensidad, velocidadpenetracion)


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

            R.id.porcentajeSolidos -> {

                val cambiar : Intent = Intent(this, porcentajeSolidos::class.java)

                startActivity(cambiar)

            }

            R.id.volumenTanqueRectangular -> {

                val cambiar : Intent = Intent(this, volumenTanqueRectangular::class.java)

                startActivity(cambiar)

            }

            R.id.volumenTanqueCilindro -> {

                val cambiar : Intent = Intent(this, volumenTanqueCilindrico::class.java)

                startActivity(cambiar)

            }

            R.id.caudalBombaBD -> {

                val cambiar : Intent = Intent(this, caudalBombaDuplex::class.java)

                startActivity(cambiar)

            }

            R.id.caudalBombaBT -> {

                val cambiar : Intent = Intent(this, caudalBombaTriplex::class.java)

                startActivity(cambiar)

            }

            R.id.reduccionSolidosDisolucion -> {

                val cambiar : Intent = Intent(this, reduccionDisolucion::class.java)

                startActivity(cambiar)

            }

            R.id.reduccionSolidosVolcado -> {

                val cambiar : Intent = Intent(this, reduccionVolcado::class.java)

                startActivity(cambiar)

            }

            R.id.densificacionBarita -> {

                val cambiar : Intent = Intent(this, densificacionBarita::class.java)

                startActivity(cambiar)

            }

            R.id.reduccionDensidad -> {

                val cambiar : Intent = Intent(this, reduccionDensidad::class.java)

                startActivity(cambiar)

            }

            R.id.velocidadPenetracion -> {

                val cambiar : Intent = Intent(this, velocidadPenetracion::class.java)

                startActivity(cambiar)

            }

        }

    }
}