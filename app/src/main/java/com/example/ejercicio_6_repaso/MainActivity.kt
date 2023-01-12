package com.example.ejercicio_6_repaso

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.Layout
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.texto).isVisible = false
        findViewById<ImageView>(R.id.batman).isVisible = false

        findViewById<Button>(R.id.botonComFi).setOnClickListener { cambioString() }


        if(findViewById<EditText>(R.id.texto).text.toString().contentEquals("Wayne"))
            findViewById<ImageView>(R.id.batman).isVisible = true

        // Mientras escriba el usuario la aplicacion tendra en cuenta lo que ponga, para cuando ponga Wayne o Joker
        findViewById<EditText>(R.id.texto).addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                findViewById<ImageView>(R.id.batman).isVisible =
                    findViewById<EditText>(R.id.texto).text.toString().contains("Wayne");
                if (findViewById<EditText>(R.id.texto).text.toString().contains("Joker")) {
                    findViewById<Button>(R.id.botonComFi).setTextColor(Color.parseColor("#FF0000"))
                    findViewById<EditText>(R.id.texto).setTextColor(Color.parseColor("#FF0000"))
                    findViewById<Button>(R.id.botonComFi).setBackgroundColor(Color.parseColor("#FF03DAC5"))
                    findViewById<View>(R.id.fondo).setBackgroundColor(Color.GREEN)

                } else {findViewById<Button>(R.id.botonComFi).setTextColor(Color.parseColor("#FFFFFFFF"))
                    findViewById<EditText>(R.id.texto).setTextColor(Color.parseColor("#FF000000"))
                        findViewById<Button>(R.id.botonComFi).setBackgroundColor(Color.parseColor("#FF6200EE"))
                        findViewById<View>(R.id.fondo).setBackgroundColor(0xFFFFFFFF.toInt())
                }
                }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {} })

        //Cuando el usuario pulsa en el editText, el texto se borra y permite la introducción de texto. Si el usuario no ha escrito
        // nada y quita el focus, entonces "Introduce tu nombre" se vuelve a mostrar.

        // Esto lo hace basicamente el atributo hint que tiene el edit text, pero también esta así por si se especificaba de esta forma
        findViewById<EditText>(R.id.texto).setOnFocusChangeListener { _: View, b: Boolean ->
            if (b){
                findViewById<EditText>(R.id.texto).setText("")

            }else
                if(findViewById<EditText>(R.id.texto).text.isEmpty())
                    findViewById<EditText>(R.id.texto).setText("Introduce tu nombre")



        }


        //findViewById<Button>(R.id.texto).visibility = View.GONE
    }

    private fun cambioString() {    // funcion que sirve para hacer cambios en el texto del boton y además para que aparzca y desaparezca el editText
        var string = findViewById<Button>(R.id.botonComFi).text.toString()
        var aux = ""
        if(string.equals("COMENZAR")) {
            findViewById<Button>(R.id.botonComFi).text = "FINALIZAR"
            findViewById<EditText>(R.id.texto).isVisible = true




        }

        if(string.equals("FINALIZAR")) {
            findViewById<Button>(R.id.botonComFi).text = "COMENZAR"
            findViewById<EditText>(R.id.texto).isVisible = false

        }

    }
}