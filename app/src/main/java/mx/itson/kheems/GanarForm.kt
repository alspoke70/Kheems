package mx.itson.kheems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import mx.itson.khemms.entidades.Winer

class GanarForm : AppCompatActivity() {
    private var vidas=0
    private var puntos=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganar_form)
        vidas =  intent.getIntExtra("vidas",0)
        puntos =  intent.getIntExtra("puntos",0)
        findViewById<Button>(R.id.btnGuardar).setOnClickListener { guardar() }

    }

    fun guardar(){
        try {
            val nombre = findViewById<EditText>(R.id.txtName).text.toString()
            Winer.guardar(this,nombre, vidas, puntos)
            finish()
        } catch (ex:Exception){
            Log.e("Ocurrio un error al guardar",ex.toString())

        }

    }


}