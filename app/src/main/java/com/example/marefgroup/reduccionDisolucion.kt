package com.example.marefgroup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.math.RoundingMode

class reduccionDisolucion : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reduccion_disolucion)

        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }

        val EditTotalM : EditText = findViewById(R.id.volumenTotalM) // volumen total métrico
        val EditTotalI : EditText = findViewById(R.id.volumenTotalI)// Volumen total imperial

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

                var axub = ((b.toDouble() / 6.29) * 1000)
                EditTotalM.hint = redondear( axub, 3).toString() + " L"
                return axub

            }else{
                var auxa = (a.toDouble() / 1000) * 6.29
                EditTotalI.hint = redondear(auxa, 3).toString() + " bbl"
                return a.toDouble()
            }

        }

        /*--------------------------------------------------*/





        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{

            val EditSolidosT : EditText = findViewById(R.id.solidostotales)
            val EditSolidosD : EditText = findViewById(R.id.solidosdeseados)



            /*Variables auxiliares para hacer los condicionales*/
            val auxTotalM = EditTotalM.text.toString()
            val auxTotalI = EditTotalI.text.toString()

            val auxSolidosT = EditSolidosT.text.toString()
            val auxSolidosD = EditSolidosD.text.toString()


            if(validacion(auxTotalM, auxTotalI) == 1 || auxSolidosT.equals("")|| auxSolidosD.equals("")){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{

                try {

                    var TotalM = extractor(auxTotalM, auxTotalI)
                    var SolidosT = auxSolidosT.toDouble()
                    var SolidosD = auxSolidosD.toDouble()

                    val volumenAgregar : TextView = findViewById(R.id.volumenAgregarM)
                    val volumenAgregarI : TextView = findViewById(R.id.volumenAgregarImp)

                    val auxVolumenAgregarL = redondear(TotalM * (SolidosT/SolidosD-1), 3)
                    val auxVolumenAgregarM3 = redondear(auxVolumenAgregarL/1000, 3)

                    volumenAgregar.text = "L = " + auxVolumenAgregarL.toString() + "   M³ = " + auxVolumenAgregarM3.toString()

                    volumenAgregarI.text = "gal = " + redondear((auxVolumenAgregarL*0.264172), 3) + "  bbl = " + redondear(auxVolumenAgregarM3*6.29, 3).toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }


            }


        }

    }
}