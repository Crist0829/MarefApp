package com.example.marefgroup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception
import java.math.RoundingMode
import kotlin.math.round

class volumenPozo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumen_pozo)



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

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() / 3.28084
                return axub

            }else{

                return a.toDouble()
            }


        }

        /* Devuelve el numero decimal redondeado */
        fun redondear(number : Double, numDecimalesPlaces: Int): Double {

            return number.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

        }



        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{


            val EditDPM : EditText = findViewById(R.id.diametroPozoM)// Diametro del pozo métrico
            val EditDPI : EditText = findViewById(R.id.diametroPozoI)// Diametro del pozo en imperial

            val EditLM  : EditText = findViewById(R.id.longitudM)//Longitud del pozo métrico
            val EditLI : EditText = findViewById(R.id.longitudI)//Longitud del pozo imperial


            /*Variables auxiliares para hacer los condicionales*/
            val auxDPM = EditDPM.text.toString()
            val auxDPI = EditDPI.text.toString()

            val auxLM = EditLM.text.toString()
            val auxLI = EditLI.text.toString()

            if(validacion(auxDPM, auxDPI) == 1 || validacion(auxLM, auxLI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {
                    var DP = extractor(auxDPM, auxDPI)
                    var Lon = extractorP(auxLM, auxLI)
                    val const : Double = 0.7854

                    val volumenPozoM : TextView = findViewById(R.id.volumenPozoM)
                    val volumenPozoI : TextView = findViewById(R.id.volumenPozoImp)

                    val auxVolumenPozoM = redondear(const * ((DP/1000)*(DP/1000)) * Lon * 1000, 3)
                    val auxVolumenPozoI = redondear(auxVolumenPozoM*0.264172, 3)

                    volumenPozoM.text = "L = " + auxVolumenPozoM.toString() + "  m³/m = " + redondear((auxVolumenPozoM / 1000), 3).toString()
                    volumenPozoI.text = "gal = " + auxVolumenPozoI.toString() + "  bbl/pie(ft) = " + redondear(((auxVolumenPozoM/1000)*6.29), 3).toString()


                    val capacidadPozoM : TextView = findViewById(R.id.capacidadPozoM)
                    val capacidadPozoI : TextView = findViewById(R.id.capacidadPozoImp)

                    val auxCapacidadPozoM = redondear(auxVolumenPozoM/Lon, 3)
                    val auxCapacidadPozoI = redondear(auxVolumenPozoI / (Lon/0.3048), 3)

                    capacidadPozoM.text = "L/m = " + auxCapacidadPozoM.toString() + "  m ³ = " +  redondear((auxCapacidadPozoM/1000), 3).toString()
                    capacidadPozoI.text = "gal/pie(ft) = " + auxCapacidadPozoI.toString() + "  bbl/pie(ft) = " + redondear(((auxVolumenPozoM / 1000)*6.29)/(Lon/0.3048), 3).toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }
            }

        }
    }
}




