package com.example.formularioconspinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.formularioconspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    var campo = ""
    var mapa = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.bAAdir.setOnClickListener { getAndSend() }
    }

    fun getAndSend() {
        val intentResult = Intent(this, ResultActivity::class.java)
        intentResult.putExtra("Nombre", b.eTCampos.text.toString())
        startActivity(intentResult)
    }


    fun getSpinner(spinner: Spinner) {
        var userSelect = ""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this, R.array.Campos,
            android.R.layout.simple_spinner_item
        )
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }
        campo = userSelect
    }
}






//hacemos una activity donde meto los campos nombre sexo edad telefono email
//hago un spinner con esos campos
//un edit.text en el que cada vez que seleccione un campo me salga para ponerlo
//un boton de añadir que cuando lo clico me lo añade un mapa que constara de la clave (sexo edad, etc) y el valor que sera lo que yo meta en el edite text
//luego un boton de enviar que me lo pase a otra actividad dnde aparezca toda la informacion puesta
//en la otra activity boton de volver
////Ejercicio 6
//
////fun main () {
////    val mapa = mutableMapOf<String, String>()
////    println("Introduce tu Nombre")
////    mapa.put("nombre", readLine()!!.toString())
////    println("Tu nombre es: ${mapa.getValue("nombre")}")
////
////    println("Intoduce tu Edad")
////    mapa.put("edad", readLine()!!)
////    println("Tu edad es: ${mapa.getValue("edad")}")
////
////    println("Introduce tu sexo")
////    mapa.put("sexo", readLine()!!)
////    println("Tu sexo es : ${mapa.getValue("sexo")}")
////
////    println("Introduce tu telefono")
////    mapa.put("telefono", readLine()!!)
////    println("Tu telefono es : ${mapa.getValue("telefono")}")
////
////    println("Introduce tu correo electronico")
////    mapa.put("correo electronico", readLine()!!)
////    println("TU correo electronico es : ${mapa.getValue("correo electronico")}")
////}
////
////ESTA ES LA MANERA EN LA QUE LA HACE LE FORMADOR
////fun main(){
////    val datos = listOf<String>("Nombre", "Edad", "Sexo", "Telefono", "Correo electronico")
////    val person = mutableMapOf<String, String>()
////    datos.forEach{
////        println("Introduce tu $it : ")              //
////        person.put (it, readLine()!!)
////        println(person.getValue(it))
////    }
////    println(person)
////}