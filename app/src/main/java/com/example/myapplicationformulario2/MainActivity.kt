package com.example.myapplicationformulario2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isEmpty
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGuardar.setOnClickListener {
            val user = textInputUsuario.editText?.text.toString()
            val email = textInputEmail.editText?.text.toString()
            val phone = textInputPhone.editText?.text.toString()
            val passWord1 = textInputPassword1.editText?.text.toString()
            val passWord2 = textInputPassword2.editText?.text.toString()

            if (user.isEmpty() || email.isEmpty() || phone.isEmpty() || passWord1.isEmpty() || passWord2.isEmpty()) {
                Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
                textInputUsuario.error = "Ingrese Usuario"
                textInputEmail.error = "Ingrese Email"
                textInputPhone.error = "Ingrese Telefono"
                textInputPassword1.error = "Ingrese Clave"
                textInputPassword2.error = "Ingrese segunda Clave"
            } else

                if (user.length >= 10) {
                    textInputUsuario.error = "Nombre debe ser menor a 10"
                } else
                    if (passWord1 != passWord2) {
                        textInputPassword1.error = "clave no coincide"
                        textInputPassword2.error = "Clave no coincide"
                    } else
                        if (user.isNotEmpty() || email.isNotEmpty() || phone.isNotEmpty() || passWord1.isNotEmpty() || passWord2.isNotEmpty()) {
                            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT)
                                .show()
                            //Metodo para quitar el error una vez se llenen los campo
                            textInputUsuario.error = null
                            textInputEmail.error = null
                            textInputPhone.error = null
                            textInputPassword1.error = null
                            textInputPassword2.error = null
                        }
            radioGroup()
            //checkBox()

        }

    }

    fun radioGroup() {
        if (radioButtonFamale.isChecked ) {
            textView2.text = ("\n Mujer")
        } else {
            textView2.text = ("\n Es hombre")
        }
    }




}