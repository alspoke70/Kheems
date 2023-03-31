package mx.itson.kheems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import mx.itson.khemms.adapters.WinerAdapter
import mx.itson.khemms.entidades.Winer

class Ganar : AppCompatActivity() {
        private var listaWiner: ListView?=null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_ganar)
            listaWiner=findViewById(R.id.listaG)
            cargarLista()
        }
    fun cargarLista() {
        val winers: List<Winer> = Winer.obtener(this)
        val adapter = WinerAdapter(this, winers)
        listaWiner?.adapter = adapter

    }
}

