package com.example.myapplicationformulario2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


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

                            //Metodo para quitar el error una vez se llenen los campo
                            textInputUsuario.error = null
                            textInputEmail.error = null
                            textInputPhone.error = null
                            textInputPassword1.error = null
                            textInputPassword2.error = null

                            textView.text = ("\n $user  \n $email \n $phone ")
                        }



            radioGroup()
            checkBox()

        }

    }

    fun radioGroup() {

        if (radioButtonFamale.isChecked ) {
            textView2.text = ("Es Mujer")
        } else {
            textView2.text = ("Es Hombre")
        }
    }

    fun checkBox(){

        if (checkBoxFutbol.isChecked && checkBoxBaloncesto.isChecked){
            textView3.text = ("Le gusta el Futbol y el Baloncesto")
        } else
        if(checkBoxFutbol.isChecked){
            textView3.text = ("Le gusta el fulbol")
        } else {
            textView3.text = ("Le gusta el Baloncesto")
        }
    }




}