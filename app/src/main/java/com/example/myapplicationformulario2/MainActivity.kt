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
            val user = textInputUsuario.editText?.text.toString()
            val email = textInputEmail.editText?.text.toString()
            val phone = textInputPhone.editText?.text.toString()
            val clave1 = textInputPassword1.editText?.text.toString()
            val clave2 = textInputPassword2.editText?.text.toString()

            if (user.isEmpty()||email.isEmpty()||phone.isEmpty()||clave1.isEmpty()||clave2.isEmpty()){
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
                textInputUsuario.error="Ingrese Usuario"
                textInputEmail.error="Ingrese Email"
                textInputPhone.error="Ingrese Telefono"
                textInputPassword1.error="Ingrese Clave"
                textInputPassword2.error="Ingrese segunda Clave"
            } else
                if (user.length > 3 ){
                    textInputEmail.error = "Nombre debe ser mayor a 3"
                }
        }

    }
}