package com.example.mascotas.presentador;

import com.example.mascotas.POJO.Mascota;

import java.util.ArrayList;

public interface IFragmentPresenter {
    public ArrayList<Mascota> obtenerDatos();
    public ArrayList<Mascota> listarFavoritos();
}
