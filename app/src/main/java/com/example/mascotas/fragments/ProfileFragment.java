package com.example.mascotas.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.POJO.Mascota;
import com.example.mascotas.R;
import com.example.mascotas.adapter.PerfilAdaptador;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    ArrayList<Mascota> mascotaPerfil;
    private RecyclerView listaPerfil;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        listaPerfil = (RecyclerView) view.findViewById(R.id.profileData);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        listaPerfil.setLayoutManager(gridLayoutManager);

        inicializarLista();
        inicializarAdaptador();
        return view;
    }

    public void inicializarLista() {
        mascotaPerfil = new ArrayList<>();
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
        mascotaPerfil.add(new Mascota(R.drawable.dog_1, 5));
    }

    public void inicializarAdaptador() {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotaPerfil, getActivity());
        listaPerfil.setAdapter(adaptador);
    }
}