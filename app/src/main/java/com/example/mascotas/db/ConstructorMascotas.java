package com.example.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.mascotas.POJO.Mascota;
import com.example.mascotas.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final Integer LIKE = 1;
    private Context context;
    private BaseDatos db;

    public ConstructorMascotas(Context context) {
        this.context = context;
        db = new BaseDatos(context);
    }

    public void insertarMascotas() {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Trosky");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_1);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Luna");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_2);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Tony");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_3);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Fito");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_4);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Danger");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_5);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);

        contentValues.put(Constantes.TABLE_PETS_NOMBRE, "Lupe");
        contentValues.put(Constantes.TABLE_PETS_IMAGEN, R.drawable.dog_1);
        contentValues.put(Constantes.TABLE_PETS_LIKES, 0);
        db.insertarDatos(contentValues);
    }

    public ArrayList<Mascota> obtenerMascotas() {
        return db.obtenerDatos();
    }

    public ArrayList<Mascota> obtenerFavoritos() {
        return db.obtenerFavoritas();
    }

    public void darLike(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        int nuevosLikes = mascota.getRanqueo() + 1;
        mascota.setRanqueo(nuevosLikes);
        db.actualizarLikes(mascota.getId(), nuevosLikes);
    }

}
