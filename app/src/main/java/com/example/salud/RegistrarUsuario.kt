package com.example.salud

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
//test
//sdfsdff
class RegistrarUsuario : AppCompatActivity() {
    private lateinit var dbHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        dbHelper = SQLiteHelper(this)

        val editTextNombre = findViewById<EditText>(R.id.etNombre)
        val editTextCorreo = findViewById<EditText>(R.id.etCorreo)
        val editTextEdad = findViewById<EditText>(R.id.etEdad)
        val editTextPeso = findViewById<EditText>(R.id.etPeso)
        val editTextAltura = findViewById<EditText>(R.id.etAltura)
        val buttonEnviar = findViewById<Button>(R.id.btnEnviar)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        // Acciones cuando el botón es presionado
        buttonEnviar.setOnClickListener {
            // Obtener los datos de los campos de texto
            val nombre = editTextNombre.text.toString()
            val correo = editTextCorreo.text.toString()
            val edad = editTextEdad.text.toString()
            val peso = editTextPeso.text.toString()
            val altura = editTextAltura.text.toString()


            // Validar que todos los campos estén completos
            if (nombre.isEmpty() || correo.isEmpty() || edad.isEmpty() || peso.isEmpty() || altura.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Mostrar los datos en un Toast (o lo que desees hacer con ellos)
                val result = dbHelper.insertUser(nombre, correo, edad.toInt(), peso.toDouble(), altura.toDouble())
                Toast.makeText(this, "Usuario insertado con ID: $result", Toast.LENGTH_SHORT).show()

            }



        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                // Regresa a la actividad principal
                val intent = Intent(this, MainActivity::class.java)
                // Opcional: Limpiar la pila de activities para evitar volver atrás
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
                true
            }

            R.id.action_back -> {
                // Finaliza la activity actual para volver a la anterior
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}