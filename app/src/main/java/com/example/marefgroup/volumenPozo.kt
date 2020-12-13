package com.example.marefgroup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import kotlin.math.round

class volumenPozo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumen_pozo)

        val backButton : Button = findViewById(R.id.backButton)
        val homeButton : Button = findViewById(R.id.home)
        val settingsButton : Button = findViewById(R.id.settings)

        settingsButton.setOnClickListener{

            val setting : Intent = Intent(this, Settings::class.java)
            startActivity(setting)

        }

        homeButton.setOnClickListener{

            val home : Intent = Intent(this, MainActivity::class.java)
            startActivity(home)

        }

        backButton.setOnClickListener{

            val home : Intent = Intent(this, Calculos::class.java)
            startActivity(home)

        }

        val calcular : Button = findViewById(R.id.calcular)

        calcular.setOnClickListener{

            val diametro : EditText = findViewById(R.id.diametro)
            val longitud : EditText = findViewById(R.id.longitud)

            val auxD = diametro.text.toString()
            val auxL = longitud.text.toString()

            if(auxD.equals("") || auxL.equals("")){

                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()

            }else{

                var dm = diametro.text.toString().toFloat()
                var lp = longitud.text.toString().toFloat()

                val constante = 0.7854;
                val resultado : Double = round3Decimales (constante*((dm/1000)*(dm/1000))*lp*1000, 3)
                var longitudPozo =  round3Decimales(resultado/lp, 3)
                val resultado1 = findViewById<TextView>(R.id.resultado1)
                val longitudpPozo2 = round3Decimales(longitudPozo/1000, 3)
                resultado1.text = "L/m = " + longitudPozo.toString() + "   m3/m = " + longitudpPozo2.toString()
                val resultado2 = findViewById<TextView>(R.id.resultado2)

                val m3 = round3Decimales(resultado/1000, 3)

                resultado2.text = "L = " + resultado.toString() + "   m3 = " + m3.toString()

                val resultado1Imp = findViewById<TextView>(R.id.resultado1Imp)
                val resultado2Imp = findViewById<TextView>(R.id.resultado2Imp)



                val resultadoImp1 =  round3Decimales(resultado * 0.264172, 5)
                val resultadoImp2 = round3Decimales(m3 * 6.29, 3)

                val lpI = round3Decimales(lp / 0.3048, 5)

                val resultado1Imp1 = round3Decimales(resultadoImp1 / lpI, 3)
                val resultado1Imp2 = round3Decimales(resultadoImp2 / lpI, 3)

                resultado1Imp.text = "Gal/pie(ft) = " + resultado1Imp1.toString() + "   bbl/pie(ft) = " + resultado1Imp2.toString()

                resultado2Imp.text = "gal = " + resultadoImp1.toString() + "   bbl = " + resultadoImp2.toString()



                resultado1.visibility = View.VISIBLE
                resultado2.visibility = View.VISIBLE
                resultado2Imp.visibility = View.VISIBLE
                resultado1Imp.visibility = View.VISIBLE
                



            }


        }

    }

    fun round3Decimales(number : Double, numDecimalesPlaces: Int): Double {

        return number.toBigDecimal().setScale(3, RoundingMode.HALF_UP).toDouble()

    }
}




