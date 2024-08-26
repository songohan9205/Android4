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

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Context context;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_mascota_card_view, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgDogCV.setImageResource(mascota.getImagen());
        holder.nombreCV.setText(mascota.getNombre());
        holder.rateoCV.setText(String.valueOf(mascota.getRanqueo()));

        holder.imgBoneCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setEsRanqueado(true);
                mascota.setRanqueo(mascota.getRanqueo() + 1);
                notifyItemChanged(position);
                Toast.makeText(context, "Puntaje agregado a" + mascota.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgDogCV;
        private TextView nombreCV;
        private TextView rateoCV;
        private ImageView imgBoneCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgDogCV = (ImageView) itemView.findViewById(R.id.imgDogCV);
            nombreCV = (TextView) itemView.findViewById(R.id.nombreCV);
            rateoCV = (TextView) itemView.findViewById(R.id.rateoCV);
            imgBoneCV = (ImageView) itemView.findViewById(R.id.imgBoneCV);
        }
    }
}
