package com.example.myapplicationformulario2

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    lateinit var dateText: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Metodo para colocar icono en el actionbar
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.mipmap.ic_launcher)


        val lista = arrayOf("Santa Marta", "Barranquilla", "Bogota", "Medellin", "Cartagena")
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista)
        spinner.adapter = adaptador1

        buttonGuardar.setOnClickListener {
            val user = textInputUsuario.editText?.text.toString()
            val email = textInputEmail.editText?.text.toString()
            val phone = textInputPhone.editText?.text.toString()
            val passWord1 = textInputPassword1.editText?.text.toString()
            val passWord2 = textInputPassword2.editText?.text.toString()

            when (spinner.selectedItem.toString()) {
                "Santa Marta" -> textView.text = ("\n $user es de Santa Marta")
                "Barranquilla" -> textView.text = ("\n $user es de Barranquilla")
                "Bogota" -> textView.text = ("\n $user es de Bogota")
                "Medellin" -> textView.text = ("\n $user es de Medellin")
                "Cartagena" -> textView.text = ("\n $user es de Cartagena")

            }


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

                            textView4.text = (" \n$email \n$phone ")
                        }


            radioGroup()
            checkBox()

        }

        buttonDate.setOnClickListener {
            showDatePickerDialog()
        }


    }

    fun radioGroup() {

        if (radioButtonFamale.isChecked) {
            textView2.text = ("Es Mujer")
        } else {
            textView2.text = ("Es Hombre")
        }
    }

    fun checkBox() {

        if (checkBoxFutbol.isChecked && checkBoxBaloncesto.isChecked) {
            textView3.text = ("Le gusta el Futbol y el Baloncesto")
        } else
            if (checkBoxFutbol.isChecked) {
                textView3.text = ("Le gusta el fulbol")
            } else {
                textView3.text = ("Le gusta el Baloncesto")
            }
    }

    //Metodo para el calendario

    fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            this,
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val date = "month/day/year: $month/$dayOfMonth/$year"
        textView5.text = date

        // dateText.text = date
    }


}