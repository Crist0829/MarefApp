package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode

class porcentajeSolidos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porcentaje_solidos)

        val backButton : Button = findViewById(R.id.backButton)

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


                var axub = b.toDouble() / 8.33
                return redondear(axub, 3)

            }else{

                var auxa : Double = redondear(a.toDouble(), 3)

                return redondear(auxa.toDouble(), 3)
            }

        }

        /*--------------------------------------------------*/


        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{



            val EditDSM : EditText = findViewById(R.id.densidadM) // Densidad del sólido
            val EditDSI : EditText = findViewById(R.id.densidadI)//Densidad del sólido en imperial

            /*Variables auxiliares para hacer los condicionales*/
            val auxDS = EditDSM.text.toString()
            val auxDSI = EditDSI.text.toString()


            if(validacion(auxDS, auxDSI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{


                var DPM = extractor(auxDS, auxDSI)

                val const : Double = 7.25
                val const2 : Double = 8.345

                val porcentajesolidos : TextView = findViewById(R.id.porcentajesolidos)

                Toast.makeText(this, DPM.toString(), Toast.LENGTH_SHORT).show()
                porcentajesolidos.text = redondear((const * ((DPM * 8.33) - const2)), 3).toString() + "%"


            }


        }


    }
}