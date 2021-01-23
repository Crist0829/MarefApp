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

class volumenAnular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumen_anular)

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


            val EditDPM : EditText = findViewById(R.id.diametroPozo) // Diametro del pozo métrico
            val EditDPI : EditText = findViewById(R.id.diametroPozoI)// Diametro del pozo en imperial

            val EditDTM : EditText = findViewById(R.id.diametroTuberia) // Diametro de tubería métrico
            val EditDTI : EditText = findViewById(R.id.diametroTuberiaI)// Diametro de tubería imperial

            val EditPM  : EditText = findViewById(R.id.profundidad) // Profundidad métrico
            val EditPI : EditText = findViewById(R.id.profundidadI) // Profundidad imperial

            /*Variables auxiliares para hacer los condicionales*/
            val auxDPM = EditDPM.text.toString()
            val auxDPI = EditDPI.text.toString()

            val auxDTM = EditDTM.text.toString()
            val auxDTI = EditDTI.text.toString()

            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            if(validacion(auxDPM, auxDPI) == 1 || validacion(auxDTM, auxDTI) == 1 || validacion(auxPM, auxPI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

               try {

                   var DPM = extractor(auxDPM, auxDPI)
                   var DTM = extractor(auxDTM, auxDTI)
                   var PM = extractorP(auxPM, auxPI)
                   val const : Double = 0.7854

                   val volumenAnular : Double = (const * (DPM/1000) * (DPM/1000) * PM * 1000) - (const * (DTM / 1000) * (DTM / 1000) * PM * 1000)

                   val volumenAnularMetrico : TextView = findViewById(R.id.volumenanularmetrico)
                   val volumenanularImp : TextView = findViewById(R.id.volumenanularimp)

                   volumenAnularMetrico.text = "L = " + redondear(volumenAnular, 3).toString()
                   volumenanularImp.text = "Gal = " + redondear((volumenAnular * 0.264172), 3).toString()

                   val capacidadAnularlm : Double =  volumenAnular / PM
                   var capacidadAnularm3m : Double = capacidadAnularlm / 1000

                   val capacidadAnularMetrico : TextView = findViewById(R.id.capacidadanularmetrico)
                   val capacidadAnularImperial : TextView = findViewById(R.id.capacidadanularimp)

                   capacidadAnularMetrico.text = "L/m = " + redondear(capacidadAnularlm, 3).toString() + "   M³/m = " + redondear(capacidadAnularm3m, 3).toString()
                   capacidadAnularImperial.text = "Gal/pie(ft) = " + redondear(((volumenAnular * 0.264172) /(PM / 0.3048)), 3).toString() + "   bbl/pie(ft) = " + redondear(((volumenAnular /1000*6.29)/(PM/0.3048)), 3).toString()

               }catch (e : Exception){

                   Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

               }



            }


        }

    }
}