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

class volumenTanqueRectangular : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumen_tanque_rectangular)

        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }

        val EditLongM : EditText = findViewById(R.id.longitudM) // Longitud
        val EditLongI : EditText = findViewById(R.id.longitudI)// Longitud en imperial

        val EditAnchoM : EditText = findViewById(R.id.anchoM) // Ancho métrico
        val EditAnchoI : EditText = findViewById(R.id.anchoI)// Ancho imperial

        val EditPM  : EditText = findViewById(R.id.profundidadM) // Profundidad métrico
        val EditPI : EditText = findViewById(R.id.profundidadI) // Profundidad imperial

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

        /* Devuelve el numero decimal redondeado */
        fun redondear(number : Double, numDecimalesPlaces: Int): Double {

            return number.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

        }

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP1(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() / 3.28084
                EditLongM.hint = redondear(axub, 3).toString() + " m"
                return axub

            }else{

                var axua = a.toDouble() * 3.28084
                EditLongI.hint = redondear(axua, 3).toString() + " pie"
                return a.toDouble()
            }


        }

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP2(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() / 3.28084
                EditAnchoM.hint = redondear(axub, 3).toString() + " m"
                return axub

            }else{

                var axua = a.toDouble() * 3.28084
                EditAnchoI.hint = redondear(axua, 3).toString() + " pie"
                return a.toDouble()
            }


        }

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de pies a metros*/
        fun extractorP3(a : String, b : String): Double{

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
            val auxLongM = EditLongM.text.toString()
            val auxLongI = EditLongI.text.toString()

            val auxAnchoM = EditAnchoM.text.toString()
            val auxAnchoI = EditAnchoI.text.toString()

            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            if(validacion(auxLongM, auxLongI) == 1 || validacion(auxAnchoM, auxAnchoI) == 1 || validacion(auxPM, auxPI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var Longitud = extractorP1(auxLongM, auxLongI)
                    var Ancho = extractorP2(auxAnchoM, auxAnchoI)
                    var PM = extractorP3(auxPM, auxPI)

                    val volumenMetrico : TextView = findViewById(R.id.volumenMetrico)

                    var auxVolumenMetricoM3 = redondear((PM * Ancho * Longitud), 3)
                    var auxVolumenMetricoL =  redondear((auxVolumenMetricoM3 * 1000), 3)

                    volumenMetrico.text = "M³ = " + auxVolumenMetricoM3.toString() + "  L = " + auxVolumenMetricoL.toString()

                    val volumenImp : TextView = findViewById(R.id.volumenImp)

                    var auxVolumenBbl = redondear((auxVolumenMetricoL*6.29), 3)
                    var auxVolumenGal = redondear((auxVolumenMetricoM3*264.172), 3)

                    volumenImp.text = "bbl = " + auxVolumenBbl.toString() + "  gal = " + auxVolumenGal.toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }

            }


        }


    }
}