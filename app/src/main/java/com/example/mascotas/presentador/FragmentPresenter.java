package com.example.mascotas.presentador;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.example.mascotas.POJO.Mascota;
import com.example.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class FragmentPresenter implements IFragmentPresenter {
    private FragmentPresenter fragmentPresenter;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public FragmentPresenter(Context context) {
        this.context = context;
        obtenerDatos();
    }

    @Override
    public ArrayList<Mascota> obtenerDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        return mascotas;
    }

    @Override
    public ArrayList<Mascota> listarFavoritos() {
        constructorMascotas = new ConstructorMascotas(context);
        return constructorMascotas.obtenerFavoritos();
    }
}
