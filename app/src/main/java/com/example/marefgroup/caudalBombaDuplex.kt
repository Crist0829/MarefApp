package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.math.RoundingMode

class caudalBombaDuplex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caudal_bomba_duplex)

        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }

        fun validacion(a : String, b : String): Int{

            var cont : Int = 0

            if(a.equals("") && b.equals("")){


                cont ++
                return cont

            }else{

                if(a.isNotBlank() && b.isNotEmpty()){

                    cont ++
                    return cont

                }else{

                    return cont

                }

            }



        }

        /*---Esta función extrae de el numero que fue escrito y si fue en el sistema imperial
         *devuelve el número convertido en métrico---*/
        fun extractor(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() * 25.39
                return axub

            }else{

                return a.toDouble()
            }

        }

        /*--------------------------------------------------*/



        /* Devuelve el numero decimal redondeado */
        fun redondear(number : Double, numDecimalesPlaces: Int): Double {

            return number.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

        }



        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{


            val EditDCM : EditText = findViewById(R.id.diametroCamisaM) // Diametro de camisa métrico
            val EditDCI : EditText = findViewById(R.id.diametroCamisaI)// Diametro de camisa imperial

            val EditLongM : EditText = findViewById(R.id.longitudVM) // Longitud del vástago métrico
            val EditLongI : EditText = findViewById(R.id.longitudVI)// Longitud del vástago imperial

            val EditLongEM  : EditText = findViewById(R.id.emboladaM) // Longitud de la embolada métrico
            val EditLongEI : EditText = findViewById(R.id.emboladaI)// Longitud de la embolada imperial

            val EditEficiencia : EditText = findViewById(R.id.eficiencia)

            val EditTiempo : EditText = findViewById(R.id.tiempoEmbolada)

            /*Variables auxiliares para hacer los condicionales*/
            val auxDCM = EditDCM.text.toString()
            val auxDCI = EditDCI.text.toString()

            val auxLongM = EditLongM.text.toString()
            val auxLongI = EditLongI.text.toString()

            val auxLongEM = EditLongEM.text.toString()
            val auxLongEI = EditLongEI.text.toString()

            val auxEfi = EditEficiencia.text.toString()

            val auxTiempo = EditTiempo.text.toString()



            if(validacion(auxDCM, auxDCI) == 1 || validacion(auxLongM, auxLongI) == 1 || validacion(auxLongEM, auxLongEI) == 1||auxEfi.equals("")||auxTiempo.equals("")){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var DCM = extractor(auxDCM, auxDCI)
                    var LongM = extractor(auxLongM, auxLongI)
                    var LongEM = extractor(auxLongEM, auxLongEI)
                    var EFI = auxEfi.toDouble()
                    var TIEMPO = auxTiempo.toDouble()
                    val const : Double = 0.000068

                    val caudalBombaMetrico : TextView = findViewById(R.id.caudalbombametrico)
                    val caudalBombaImp : TextView = findViewById(R.id.caudalbombaImp)

                    val auxCaudalImperial = redondear((const * (2*((DCM / 25.39) * (DCM / 25.39)) - ((LongM / 25.39) * (LongM / 25.39)))*(LongEM / 25.39) * EFI * TIEMPO), 3)

                    val auxCaudalMetrico = redondear(auxCaudalImperial*3.7585, 3)

                    caudalBombaMetrico.text = "L/min = " + auxCaudalMetrico.toString() + "   L/Embolada = " + (auxCaudalMetrico/TIEMPO).toString()
                    caudalBombaImp.text = "Gal/min = " + auxCaudalImperial.toString() + "  Gal/Embolada = " + redondear((auxCaudalImperial/TIEMPO), 3).toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }


            }


        }


    }
}