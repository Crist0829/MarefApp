package com.example.marefgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.math.RoundingMode

class reduccionDensidad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reduccion_densidad)


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

        fun extractorV(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() * 3.785
                return axub

            }else{

                return a.toDouble()
            }

        }


        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{

            val EditVolumenInicialM : EditText = findViewById(R.id.volumenInicialM)//Volumen inicial métrico
            val EditVolumenInicialI : EditText = findViewById(R.id.volumenInicialI)//Volumen inicial imperial

            val EditPesoIncialM : EditText = findViewById(R.id.pesoinicialM) // Peso inicial métrico
            val EditPesoInicialI : EditText = findViewById(R.id.pesoinicialI)// peso inicial imperial

            val EditPesoDeseadoM : EditText = findViewById(R.id.pesodeseadoM) // Peso deseado métricos
            val EditPesoDeseadoI : EditText = findViewById(R.id.pesodeseadoI) // Peso deseado imperial

            val EditPesoFluidoM : EditText = findViewById(R.id.pesofluidoM)//Peso de fluido de disolucion metrico
            val EditPesoFluidoI : EditText = findViewById(R.id.pesofluidoI)

            /*Variables auxiliares para hacer los condicionales*/

            val auxVolumenInicialM = EditVolumenInicialM.text.toString()
            val auxVolumenInicialI = EditVolumenInicialI.text.toString()

            val auxPesoInicialM = EditPesoIncialM.text.toString()
            val auxPesoInicialI= EditPesoInicialI.text.toString()

            val auxPesoDeseadoM = EditPesoDeseadoM.text.toString()
            val auxPesoDeseadoI = EditPesoDeseadoI.text.toString()

            val auxPesoFluidoM = EditPesoFluidoM.text.toString()
            val auxPesoFluidoI = EditPesoFluidoI.text.toString()


            if(validacion(auxPesoInicialM, auxPesoInicialI) == 1 || validacion(auxPesoDeseadoM, auxPesoDeseadoI) == 1
                || validacion(auxVolumenInicialM, auxVolumenInicialI) == 1 || validacion(auxPesoFluidoM, auxPesoFluidoI) == 1 ){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else{


                try {

                    var volumenInicial = extractorV(auxVolumenInicialM, auxVolumenInicialI)
                    var pesoInicial = extractor(auxPesoInicialM, auxPesoInicialI)
                    var pesoDeseado = extractor(auxPesoDeseadoM, auxPesoDeseadoI)
                    var pesoFluido = extractor(auxPesoFluidoM, auxPesoFluidoI)

                    val volumenA : TextView = findViewById(R.id.volumenAM)
                    val volumenI : TextView = findViewById(R.id.volumenAI)

                    val auxVolumenA = redondear(((volumenInicial * (pesoInicial - pesoDeseado))/(pesoDeseado - pesoFluido)), 3)
                    volumenA.text = "L = " + auxVolumenA.toString()

                    volumenI.text = "Gal = " + redondear(auxVolumenA / 3.785, 3).toString()


                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }

            }


        }

    }
}