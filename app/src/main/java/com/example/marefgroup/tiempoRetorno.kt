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

class tiempoRetorno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo_retorno)

        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }

        val EditDPM : EditText = findViewById(R.id.diametroPozo) // Diametro del pozo métrico
        val EditDPI : EditText = findViewById(R.id.diametroPozoI)// Diametro del pozo en imperial

        val EditDTM : EditText = findViewById(R.id.diametroTuberia) // Diametro de tubería métrico
        val EditDTI : EditText = findViewById(R.id.diametroTuberiaI)// Diametro de tubería imperial

        val EditCB  : EditText = findViewById(R.id.caudalbombam) // Caudal de la bomba
        val EditCBI : EditText = findViewById(R.id.caudalbombaI) // Caudal de la bomba imperial

        val EditPM  : EditText = findViewById(R.id.profundidad) // Profundidad métrico
        val EditPI : EditText = findViewById(R.id.profundidadI) // Profundidad imperial

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

                var axub = b.toDouble() * 25.39
                EditDPM.hint = redondear(axub, 3).toString() + " mm"
                return axub

            }else{

                var axua = a.toDouble() / 25.39

                EditDPI.hint = redondear(axua, 3).toString() + " pul"
                return a.toDouble()
            }

        }

        /*--------------------------------------------------*/

        /*---Esta función extrae de el numero que fue escrito y si fue en el sistema imperial
         *devuelve el número convertido en métrico---*/
        fun extractorDT(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() * 25.39
                EditDTM.hint = redondear(axub, 3).toString() + " mm"
                return axub

            }else{

                var axua = a.toDouble() / 25.39

                EditDTI.hint = redondear(axua, 3).toString() + " pul"
                return a.toDouble()
            }

        }

        /*--------------------------------------------------*/

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de litros a galones*/
        fun extractorP(a : String, b : String): Double{

            if(a.equals("")){

                var auxb : Double = redondear(b.toDouble(), 3)
                var axub = redondear((auxb * 3.785), 3)
                EditCB.hint = axub.toString() + " L/min"
                return axub

            }else{

                var auxa : Double = redondear(a.toDouble(), 3)
                val axua = redondear(auxa / 3.785, 3)
                EditCBI.hint = axua.toString() + " gal/min"
                return auxa.toDouble()
            }


        }

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorpro(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() / 3.28084
                EditPM.hint = redondear(axub, 3).toString() + " m"
                return axub

            }else{

                var axua = a.toDouble() * 3.28084
                EditPI.hint = redondear(axua, 3).toString() + " pie"
                return a.toDouble()
            }


        }


        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{

            /*Variables auxiliares para hacer los condicionales*/
            val auxDPM = EditDPM.text.toString()
            val auxDPI = EditDPI.text.toString()

            val auxDTM = EditDTM.text.toString()
            val auxDTI = EditDTI.text.toString()

            val auxCB = EditCB.text.toString()
            val auxCBI = EditCBI.text.toString()

            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            if(validacion(auxDPM, auxDPI) == 1 || validacion(auxDTM, auxDTI) == 1 || validacion(auxCB, auxCBI) == 1 || validacion(auxPM, auxPI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var DPM = extractor(auxDPM, auxDPI)
                    var DTM = extractorDT(auxDTM, auxDTI)
                    var CB = extractorP(auxCB, auxCBI)
                    var PM = extractorpro(auxPM, auxPI)
                    val const : Double = 0.7854
                    val resultado : TextView = findViewById(R.id.resultado)

                    var auxResultado = ((const * (DPM/1000) * (DPM/1000) * PM * 1000) - (const * (DTM / 1000) * (DTM / 1000) * PM * 1000))/CB
                    resultado.text = "Min = " + redondear(auxResultado, 3).toString()
                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }

            }

        }

    }
}