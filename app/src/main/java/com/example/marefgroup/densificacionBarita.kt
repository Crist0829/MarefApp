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
import org.w3c.dom.Text
import java.lang.Exception
import java.math.RoundingMode

class densificacionBarita : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_densificacion_barita)

        val backButton : Button = findViewById(R.id.backButton)

        backButton.setOnClickListener{

            val back : Intent = Intent(this, Calculos::class.java)
            startActivity(back)

        }


        var const : Double = 1.0 //Esta es la constante que sería el peso de la barita que cambiará de valor cada vez
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
                    val bot5 : TextView = findViewById(R.id.b5)

                    bot1.setBackgroundResource(R.color.naranja)
                    bot1.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    bot5.setBackgroundResource(R.color.white)
                    bot5.setTextColor(Color.BLACK)

                    const = 3.8

                }

                R.id.b2 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)
                    val bot5 : TextView = findViewById(R.id.b5)

                    bot2.setBackgroundResource(R.color.naranja)
                    bot2.setTextColor(Color.WHITE)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    bot5.setBackgroundResource(R.color.white)
                    bot5.setTextColor(Color.BLACK)

                    const = 3.9

                }

                R.id.b3 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)
                    val bot5 : TextView = findViewById(R.id.b5)

                    bot3.setBackgroundResource(R.color.naranja)
                    bot3.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    bot5.setBackgroundResource(R.color.white)
                    bot5.setTextColor(Color.BLACK)

                    const = 4.0

                }

                R.id.b4 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)
                    val bot5 : TextView = findViewById(R.id.b5)

                    bot4.setBackgroundResource(R.color.naranja)
                    bot4.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    bot5.setBackgroundResource(R.color.white)
                    bot5.setTextColor(Color.BLACK)

                    const = 4.1

                }

                R.id.b5 ->{

                    val bot1 : TextView = findViewById(R.id.b1)
                    val bot2 : TextView = findViewById(R.id.b2)
                    val bot3 : TextView = findViewById(R.id.b3)
                    val bot4 : TextView = findViewById(R.id.b4)
                    val bot5 : TextView = findViewById(R.id.b5)

                    bot5.setBackgroundResource(R.color.naranja)
                    bot5.setTextColor(Color.WHITE)

                    bot2.setBackgroundResource(R.color.white)
                    bot2.setTextColor(Color.BLACK)

                    bot3.setBackgroundResource(R.color.white)
                    bot3.setTextColor(Color.BLACK)

                    bot4.setBackgroundResource(R.color.white)
                    bot4.setTextColor(Color.BLACK)

                    bot1.setBackgroundResource(R.color.white)
                    bot1.setTextColor(Color.BLACK)

                    const = 4.2

                }


            }

        }


        fun listeners(){

            val b1 : TextView = findViewById(R.id.b1)
            val b2: TextView = findViewById(R.id.b2)
            val b3 : TextView = findViewById(R.id.b3)
            val b4 : TextView = findViewById(R.id.b4)
            val b5 : TextView = findViewById(R.id.b5)

            val Botonnes = listOf<View>(b1, b2, b3, b4, b5)

            for(boton in Botonnes){

                boton.setOnClickListener{ establecer(it)}

            }



        }

        listeners()

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



            val EditPesoIncialM : EditText = findViewById(R.id.pesoinicialM) // Peso inicial métrico
            val EditPesoInicialI : EditText = findViewById(R.id.pesoinicialI)// peso inicial imperial

            val EditPesoDeseadoM : EditText = findViewById(R.id.pesodeseadoM) // Peso deseado métricos
            val EditPesoDeseadoI : EditText = findViewById(R.id.pesodeseadoI) // Peso deseado imperial

            /*Variables auxiliares para hacer los condicionales*/
            val auxPesoInicialM = EditPesoIncialM.text.toString()
            val auxPesoInicialI= EditPesoInicialI.text.toString()

            val auxPesoDeseadoM = EditPesoDeseadoM.text.toString()
            val auxPesoDeseadoI = EditPesoDeseadoI.text.toString()


            if(validacion(auxPesoInicialM, auxPesoInicialI) == 1 || validacion(auxPesoDeseadoM, auxPesoDeseadoI) == 1){


                Toast.makeText(this, "Por favor, para cada medida llenar un campo", Toast.LENGTH_SHORT).show()


            }else if (const == 1.0){

                Toast.makeText(this, "Por favor, selecciona el peso de barita", Toast.LENGTH_SHORT).show()

            }else{


                try {
                    var pesoInicial = extractor(auxPesoInicialM, auxPesoInicialI)
                    var pesoDeseado = extractor(auxPesoDeseadoM, auxPesoDeseadoI)

                    val densificacionBaritaM : TextView = findViewById(R.id.densificacionBaritaMetrico)

                    val auxDensificacionBarita = redondear((const * 1000 * (pesoDeseado - pesoInicial)) / (const - pesoDeseado), 3)

                    densificacionBaritaM.text = "Kg/m³ = " + auxDensificacionBarita.toString()

                    val densificacionBaritaI : TextView = findViewById(R.id.densificacionBaritaImp)

                    var constI : Double = 1.0


                    when(const){

                        3.8 -> constI = 31.7
                        3.9 -> constI = 32.5
                        4.0 -> constI = 33.4
                        4.1 -> constI = 34.2
                        4.2 -> constI = 35.1

                    }


                    val auxdensificacionBaritaImp = redondear((42 * constI * ((pesoDeseado * 8.33) - (pesoInicial * 8.33))) / (constI - (pesoDeseado * 8.33)), 3)

                    densificacionBaritaI.text = "Libras = " + auxdensificacionBaritaImp.toString()

                }catch (e : Exception){

                    Toast.makeText(this, "Verifica que en cada campo hay un valor correcto", Toast.LENGTH_SHORT).show()

                }

            }


        }





    }

}