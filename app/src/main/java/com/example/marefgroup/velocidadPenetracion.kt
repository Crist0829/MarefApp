package com.example.marefgroup

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception
import java.math.RoundingMode

class velocidadPenetracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_velocidad_penetracion)

        var const : Double = 1.0 //Esta es la constante que sería el factor que cambiará de valor cada vez
        //que el usuario presione el botón correspondiente


        /*Esta función identifica qué botón fue presionado, de esta manera
        * cambia el color de fondo y el color del texto del botón presionado
        * y establece el color de fondo y el color de texto de los demás botones*/
        fun establecer (view : View){

            when(view.id){

                R.id.b1 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)

                    bot1.setBackgroundResource(R.color.naranja)
                    bot1.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)


                    const = 0.001571

                }

                R.id.b2 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)

                    bot2.setBackgroundResource(R.color.naranja)
                    bot2.setTextColor(Color.WHITE)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    const = 0.002347

                }

                R.id.b3 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)

                    bot3.setBackgroundResource(R.color.naranja)
                    bot3.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    const = 0.003143

                }

                R.id.b4 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)

                    bot4.setBackgroundResource(R.color.naranja)
                    bot4.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    const = 0.003918

                }


            }

        }


        fun listeners(){

            val b1 : TextView = findViewById(R.id.b1)
            val b2: TextView = findViewById(R.id.b2)
            val b3 : TextView = findViewById(R.id.b3)
            val b4 : TextView = findViewById(R.id.b4)

            val Botonnes = listOf<View>(b1, b2, b3, b4)

            for(boton in Botonnes){

                boton.setOnClickListener{ establecer(it)}

            }

        }

        listeners()

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

        /*Hace lo mismo que la función anterior pero aplicando la forma para pasar
        * de galones a litros*/
        fun extractorCB(a : String, b : String): Double{

            if(a.equals("")){

                var axub = b.toDouble() * 3.785
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

            val EditPM  : EditText = findViewById(R.id.profundidad) // Profundidad métrico
            val EditPI : EditText = findViewById(R.id.profundidadI) // Profundidad imperial

            val EditCBM : EditText = findViewById(R.id.caudalBombaM)
            val EditCBI : EditText = findViewById(R.id.caudalBombaI)

            /*Variables auxiliares para hacer los condicionales*/
            val auxDPM = EditDPM.text.toString()
            val auxDPI = EditDPI.text.toString()

            val auxPM = EditPM.text.toString()
            val auxPI = EditPI.text.toString()

            val auxCBM = EditCBM.text.toString()
            val auxCBI = EditCBI.text.toString()


            if(validacion(auxDPM, auxDPI) == 1 || validacion(auxPM, auxPI) == 1 || validacion(auxCBM, auxCBI) == 1){

                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()

            }else if(const == 1.0){

                Toast.makeText(this, "Selecciona un factor", Toast.LENGTH_SHORT).show()

            }


            else{

                try {

                    var DPM = extractor(auxDPM, auxDPI)
                    var PM = extractorP(auxPM, auxPI)
                    var CB = extractorCB(auxCBM, auxCBI)

                    val velocidapenetracion : TextView = findViewById(R.id.velocidadpenetracion)

                    velocidapenetracion.text = "Min/barra = " + redondear((const * (DPM * DPM) * PM / CB), 5).toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }


            }


        }
    }
}