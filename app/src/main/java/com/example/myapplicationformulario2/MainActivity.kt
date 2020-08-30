package com.example.myapplicationformulario2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGuardar.setOnClickListener {
            val usuario = textInputUsuario.editText?.text.toString()
            

            if (usuario.isEmpty()){

                Toast.makeText(this, "El campo no puede estar vacio", Toast.LENGTH_SHORT).show()

            }
        }

    }
}