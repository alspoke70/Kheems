package mx.itson.khemms.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import mx.itson.kheems.R
import mx.itson.khemms.entidades.Winer

class WinerAdapter(context: Context, private var winners: List<Winer>) : BaseAdapter() {
    //crea una instancia del tcontexto de la app
    private var context: Context? = context
    override fun getCount(): Int {
        return winners.size

    }

    //el p0 es pocision en el arreglo
    override fun getItem(p0: Int): Any {
        return winners[p0]
    }

    override fun getItemId(p0: Int): Long {
        return winners[p0].id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val renglon= LayoutInflater.from(context).inflate(R.layout.item_winer,null)
        try {

            val winner = getItem(p0) as Winer

            val txtlugar: TextView = renglon.findViewById(R.id.txtlugar)
            val txtnombre: TextView = renglon.findViewById(R.id.txtnombre)
            val txtpuntos: TextView = renglon.findViewById(R.id.txtpuntos)
            val txtvidas: TextView = renglon.findViewById(R.id.txtvidas)

            txtlugar.text = "${p0 + 1} lugar"
            txtnombre.text = winner.nombre
            txtpuntos.text = "Puntos: ${winner.puntos}"
            txtvidas.text = "Intentos: ${winner.vidas}"

        } catch (ex: Exception) {

            Log.e("ocurrio un error al obtener ganador", ex.toString())
        }

        return renglon
    }





}