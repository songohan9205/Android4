package com.example.mascotas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.Mascota;
import com.example.mascotas.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Context context;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_profile, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgDogCV.setImageResource(mascota.getImagen());
        holder.rateoCV.setText(String.valueOf(mascota.getRanqueo()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgDogCV;
        private TextView rateoCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDogCV = (ImageView) itemView.findViewById(R.id.imgDogCVProfile);
            rateoCV = (TextView) itemView.findViewById(R.id.rateoCVProfile);
        }
    }
}
