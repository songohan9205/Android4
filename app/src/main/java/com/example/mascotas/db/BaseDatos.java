package com.example.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mascotas.POJO.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, Constantes.DATABASE_NAME, null, Constantes.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTabla = "CREATE TABLE " +Constantes.TABLE_PETS + "(" +
                Constantes.TABLE_PETS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Constantes.TABLE_PETS_NOMBRE + " TEXT, " +
                Constantes.TABLE_PETS_IMAGEN + " INTEGER, " +
                Constantes.TABLE_PETS_LIKES + " INTEGER " + ")";
        sqLiteDatabase.execSQL(queryCrearTabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("BaseDatos", "onUpgrade: de ");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Constantes.TABLE_PETS);
        onCreate(sqLiteDatabase);
    }

    public void insertarDatos(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(Constantes.TABLE_PETS, null, contentValues);
        db.close();
    }

    public ArrayList<Mascota> obtenerDatos() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + Constantes.TABLE_PETS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()) {

            Mascota actual = new Mascota();
            actual.setId(registros.getInt(0));
            actual.setNombre(registros.getString(1));
            actual.setImagen(registros.getInt(2));
            actual.setRanqueo(registros.getInt(3));
            mascotas.add(actual);
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerFavoritas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + Constantes.TABLE_PETS + " WHERE " + Constantes.TABLE_PETS_LIKES + " >= 1 ORDER BY "+ Constantes.TABLE_PETS_LIKES + " DESC LIMIT 5";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota actual = new Mascota();
            actual.setId(registros.getInt(0));
            actual.setNombre(registros.getString(1));
            actual.setImagen(registros.getInt(2));
            actual.setRanqueo(registros.getInt(3));
            mascotas.add(actual);
        }
        db.close();
        return mascotas;
    }

    public void actualizarLikes(int idMascota, int nuevosLikes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constantes.TABLE_PETS_LIKES, nuevosLikes);
        db.update(Constantes.TABLE_PETS, contentValues, "id = ?", new String[]{String.valueOf(idMascota)});
        db.close();
    }
}
