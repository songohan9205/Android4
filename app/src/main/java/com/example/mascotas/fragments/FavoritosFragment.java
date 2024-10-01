package com.example.mascotas.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.POJO.Mascota;
import com.example.mascotas.R;
import com.example.mascotas.adapter.MascotaAdaptador;
import com.example.mascotas.db.BaseDatos;
import com.example.mascotas.presentador.FragmentPresenter;

import java.util.ArrayList;

public class FavoritosFragment extends Fragment {
    private RecyclerView listaMascotas;
    private FragmentPresenter presenter;
    private ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);
        listaMascotas = (RecyclerView) view.findViewById(R.id.rvMascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        TextView noFavoritosLabel = view.findViewById(R.id.no_favoritos_label);
        presenter = new FragmentPresenter(getContext());
        mascotas = presenter.listarFavoritos();

        if (mascotas.isEmpty()) {
            noFavoritosLabel.setVisibility(View.VISIBLE);
            listaMascotas.setVisibility(View.GONE);
        } else {
            noFavoritosLabel.setVisibility(View.GONE);
            listaMascotas.setVisibility(View.VISIBLE);
            inicializarAdaptador();
        }

        return view;
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
}
