package mx.itson.kheems

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var ubicacion = 0
    var aciertos = 0
    var vidas = 1
    var puntos = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciar()
        val btnIniciar = findViewById<View>(R.id.btnReiniciar) as Button
        btnIniciar.setOnClickListener(this)
        val btnResultado = findViewById<View>(R.id.btnResultados) as Button
        btnResultado.setOnClickListener(this)
        for (i in 1..6) {
            val btnSeleccion = findViewById<View>(
                resources.getIdentifier(
                    "opcion$i",
                    "id",
                    this.packageName
                )
            ) as ImageButton
            btnSeleccion.setOnClickListener(this)
        }
    }

    fun iniciar() {
        findViewById<View>(R.id.opcion1).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion2).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion3).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion4).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion5).setBackgroundResource(R.drawable.icon_pregunta)
        findViewById<View>(R.id.opcion6).setBackgroundResource(R.drawable.icon_pregunta)



        for (i in 1..6) {
            val btnSeleccion = findViewById<View>(
                resources.getIdentifier(
                    "opcion$i",
                    "id",
                    this.packageName
                )
            ) as ImageButton
            btnSeleccion.isEnabled = true
        }
        aciertos = 0
        val random = Random()
    }

    fun destapar(opcion: Int) {
        if (opcion == ubicacion) {
            Toast.makeText(this, "¡PERMDISTE!", Toast.LENGTH_LONG).show()
            for (i in 1..6) {
                // Iteramos cada carta (o botón)
                val btnSeleccion = findViewById<View>(
                    resources.getIdentifier(
                        "opcion$i",
                        "id",
                        this.packageName
                    )
                ) as ImageButton
                if (i == opcion) {
                    // Se destapa la carta mala del cheems llorando
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems_llora)
                } else {
                    // Todas las cartas restantes se destapan con el cheems normal
                    btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
                }
            }
        } else {
            aciertos++


            // No perdió todavía, por lo tanto se destapa solo esa carta con el cheems normal
            val btnSeleccion = findViewById<View>(
                resources.getIdentifier(
                    "opcion$opcion",
                    "id",
                    this.packageName
                )
            ) as ImageButton
            btnSeleccion.setBackgroundResource(R.drawable.icon_cheems)
            val btnSeleccionado = findViewById<View>(
                resources.getIdentifier(
                    "opcion$opcion",
                    "id",
                    this.packageName
                )
            ) as ImageButton
            btnSeleccionado.isEnabled = false
            if (aciertos == 5) {
                btnSeleccion.setBackgroundResource(R.drawable.cheems_win)
                Toast.makeText(this, "¡ganaste!", Toast.LENGTH_LONG).show()
                val intentGanador = Intent(this, GanarForm::class.java)
                intentGanador.putExtra("vidas", vidas)
                intentGanador.putExtra("puntos", puntos)

                startActivity(intentGanador)
                aciertos = 0
                vidas = 1
                puntos = 0

            }
        }
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnReiniciar -> iniciar()
            R.id.opcion1 -> destapar(1)
            R.id.opcion2 -> destapar(2)
            R.id.opcion3 -> destapar(3)
            R.id.opcion4 -> destapar(4)
            R.id.opcion5 -> destapar(5)
            R.id.opcion6 -> destapar(6)

            R.id.btnResultados -> {
                val intent = Intent(this, Ganar::class.java)
                startActivity(intent)


            }
        }
    }
}


