package com.android.jgg.petagram;

import android.support.annotation.NonNull;
import android.support.v7.widget.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;

    public MascotaAdapter(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.mFoto.setImageResource(mascota.getImg());
        holder.mNombre.setText(mascota.getNombre());
        holder.mRating.setText(mascota.getRatingAsString());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView mNombre;
        TextView mRating;
        ImageView mFoto;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            // cv = (CardView) findViewById(R.id.cv_mascota);
            mNombre = itemView.findViewById(R.id.mNombre);
            mRating = itemView.findViewById(R.id.mRating);
            mFoto   = (ImageView) itemView.findViewById(R.id.mFoto);

        }
    }
}
