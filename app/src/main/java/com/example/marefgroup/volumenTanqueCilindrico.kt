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

class volumenTanqueCilindrico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumen_tanque_cilindrico)

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


            val EditDM : EditText = findViewById(R.id.diametroM) // Diametro métrico
            val EditDI : EditText = findViewById(R.id.diametroI)// Diametro imperial

            val EditPM  : EditText = findViewById(R.id.profundidad) // Profundidad métrico
            val EditPI : EditText = findViewById(R.id.profundidadI) // Profundidad imperial

            /*Variables auxiliares para hacer los condicionales*/
            val auxDM = EditDM.text.toString()
            val auxDI = EditDI.text.toString()


            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            if(validacion(auxDM, auxDI) == 1 || validacion(auxPM, auxPI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                var DM = extractorP(auxDM, auxDI)
                var PM = extractorP(auxPM, auxPI)
                val const : Double = 3.141592

                val volumenMetrico : TextView = findViewById(R.id.volumenmetrico)

                val auxVolumenMetricoM3 = redondear((const * ((DM / 2) * (DM / 2)) * 2), 3)
                val auxVolumenL = auxVolumenMetricoM3 * 1000

                volumenMetrico.text = "M3 = " + auxVolumenMetricoM3.toString() + "  L = " + auxVolumenL.toString()


                val volumenImperial : TextView = findViewById(R.id.volumenimp)

                val auxVolumenImpGal = redondear((auxVolumenMetricoM3*264.172) , 3)
                val auxVolumenImpbbl = redondear((auxVolumenL*6.29), 3)

                volumenImperial.text = "gal = " + auxVolumenImpGal.toString() + "  bbl = " + auxVolumenImpbbl.toString()




            }


        }

    }
}