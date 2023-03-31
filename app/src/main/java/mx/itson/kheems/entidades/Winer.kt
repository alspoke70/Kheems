package mx.itson.khemms.entidades

import android.content.ContentValues
import android.content.Context
import android.content.LocusId
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import mx.itson.khemms.persistencia.KheemsDB

class Winer {
    var id: Int = 0
    var nombre: String? = null
    var vidas: Int = 0
    var puntos: Int = 0
    constructor()
    constructor(id: Int, nombre: String?)


    companion object {
        fun guardar(context: Context, nombre: String?, vidas: Int, puntos: Int) {

            //se intenta guardar en BD o salta el error
            try {
                val khemsDB = KheemsDB(context, "KhemsDB", null, 1)
                val baseDatos: SQLiteDatabase
                baseDatos = khemsDB.writableDatabase

                val valores = ContentValues()
                valores.put("nombre", nombre)
                valores.put("vidas", vidas)
                valores.put("puntos", puntos)
                baseDatos.insert("ganador", null, valores)
            } catch (ex: Exception) {
                Log.e("ocurrio un error al guardar ganador", ex.toString())
            }
        }

        fun obtener(context: Context?): List<Winer> {

            val khemsDB = KheemsDB(context, "KhemsDB", null, 1)
            val baseDatos = khemsDB.readableDatabase


            val winners: MutableList<Winer> = ArrayList()

            try {

                val cursor: Cursor = baseDatos.rawQuery("SELECT * FROM ganador", null)


                if (cursor.moveToFirst()) {
                    do {


                        val winer = Winer()
                        winer.id = cursor.getInt(0)
                        winer.nombre = cursor.getString(1)
                        winer.vidas = cursor.getInt(2)
                        winer.puntos = cursor.getInt(3)



                        winners.add(winer)
                    } while (cursor.moveToNext())
                }


                cursor.close()

            } catch (ex: Exception) {

                Log.e("ocurrio un error al obtener ganadores", ex.toString())
            }


            return winners


        }

    }


}