package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        var preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE)

        btnGuardar.setOnClickListener {
            val editor = preferencias.edit()
            editor.putString(txtNombre.text.toString(),txtDatos.text.toString())
            editor.commit()
            Toast.makeText(this, "Datos Grabados", Toast.LENGTH_LONG).show()
            txtNombre.setText("")
            txtDatos.setText("")
        }

        btnRecuperar.setOnClickListener {
            val datos = preferencias.getString(txtNombre.text.toString(), "")
            if (datos?.length == 0) {
                Toast.makeText(this, "No existre nombre en" + "la agenda", Toast.LENGTH_LONG).show()
            } else {
                txtDatos.setText(datos)
            }
        }
    }
}
