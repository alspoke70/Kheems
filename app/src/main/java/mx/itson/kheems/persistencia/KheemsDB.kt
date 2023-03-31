package mx.itson.khemms.persistencia

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class KheemsDB(

    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {


    @SuppressLint("LongLogTag")
    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {

            sqliteDatabase.execSQL(
                "CREATE TABLE Ganador" +
                        "(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre TEXT, vidas INTEGER, puntos INTEGER)"
            )
        } catch (ex: Exception) {
        }
    }

    override fun onUpgrade(sqliteDatabase: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        sqliteDatabase.execSQL("DROP TABLE IF EXISTS Ganador")
        onCreate(sqliteDatabase)
    }
}