package com.example.marefgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.Exception
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

        val EditDM : EditText = findViewById(R.id.diametroM) // Diametro métrico
        val EditDI : EditText = findViewById(R.id.diametroI)// Diametro imperial

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

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP1(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() / 3.28084
                EditDM.hint = redondear(axub, 3).toString() + " m"
                return axub

            }else{

                var axua = a.toDouble() * 3.28084
                EditDI.hint = redondear(axua, 3).toString() + " pie"
                return a.toDouble()
            }


        }

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP2(a : String, b : String): Double{

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
            val auxDM = EditDM.text.toString()
            val auxDI = EditDI.text.toString()


            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            if(validacion(auxDM, auxDI) == 1 || validacion(auxPM, auxPI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var DM = extractorP1(auxDM, auxDI)
                    var PM = extractorP2(auxPM, auxPI)
                    val const : Double = 3.141592

                    val volumenMetrico : TextView = findViewById(R.id.volumenmetrico)

                    val auxVolumenMetricoM3 = redondear((const * ((DM / 2) * (DM / 2)) * 2), 3)
                    val auxVolumenL = auxVolumenMetricoM3 * 1000

                    volumenMetrico.text = "M³ = " + auxVolumenMetricoM3.toString() + "  L = " + auxVolumenL.toString()


                    val volumenImperial : TextView = findViewById(R.id.volumenimp)

                    val auxVolumenImpGal = redondear((auxVolumenMetricoM3*264.172) , 3)
                    val auxVolumenImpbbl = redondear(((auxVolumenL/1000)*6.29), 3)

                    volumenImperial.text = "gal = " + auxVolumenImpGal.toString() + "  bbl = " + auxVolumenImpbbl.toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }




            }


        }

    }
}