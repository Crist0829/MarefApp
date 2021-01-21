package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.math.RoundingMode

class velocidadAnularLodo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_velocidad_anular_lodo)

        val backButton : Button = findViewById(R.id.backButton)
        val homeButton : Button = findViewById(R.id.home)
        val settingsButton : Button = findViewById(R.id.settings)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }

        /* Devuelve el numero decimal redondeado */
        fun redondear(number : Double, numDecimalesPlaces: Int): Double {

            return number.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

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


                var axub = b.toDouble() * 25.4
                return redondear(axub, 3)

            }else{

                var auxa : Double = redondear(a.toDouble(), 3)

                return redondear(auxa.toDouble(), 3)
            }

        }

        /*--------------------------------------------------*/

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP(a : String, b : String): Double{

            if(a.equals("")){

                var auxb : Double = redondear(b.toDouble(), 3)

                var axub = redondear((auxb * 3.785), 3)
                return axub

            }else{

                var auxa : Double = redondear(a.toDouble(), 3)
                return auxa.toDouble()
            }


        }





        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{



            val EditDPM : EditText = findViewById(R.id.diametroPozo) // Diametro del pozo métrico
            val EditDPI : EditText = findViewById(R.id.diametroPozoI)// Diametro del pozo en imperial

            val EditDTM : EditText = findViewById(R.id.diametroTuberia) // Diametro de tubería métrico
            val EditDTI : EditText = findViewById(R.id.diametroTuberiaI)// Diametro de tubería imperial

            val EditCB  : EditText = findViewById(R.id.caudalbombam) // Profundidad métrico
            val EditCBI : EditText = findViewById(R.id.caudalbombaI) // Profundidad imperial

            /*Variables auxiliares para hacer los condicionales*/
            val auxDPM = EditDPM.text.toString()
            val auxDPI = EditDPI.text.toString()

            val auxDTM = EditDTM.text.toString()
            val auxDTI = EditDTI.text.toString()

            val auxCB = EditCB.text.toString()
            val auxCBI = EditCBI.text.toString()

            if(validacion(auxDPM, auxDPI) == 1 || validacion(auxDTM, auxDTI) == 1 || validacion(auxCB, auxCBI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{


                var DPM = extractor(auxDPM, auxDPI)
                var DTM = extractor(auxDTM, auxDTI)
                var CB = extractorP(auxCB, auxCBI)
                val const : Double = 1270.0

                val velocidadanular : Double = redondear((const * CB) / ((DPM * DPM) - (DTM * DTM)), 3)
                val velocidadanularMetrico : TextView = findViewById(R.id.velocidadanularmetrico)
                val velocidadanularImp : TextView = findViewById(R.id.velocidadanularimp)

                velocidadanularMetrico.text = "m/min = " + redondear(velocidadanular, 3).toString()
                velocidadanularImp.text = "Pie(ft) = " +  redondear((velocidadanular / 0.3048), 3).toString()



            }


        }

    }
}