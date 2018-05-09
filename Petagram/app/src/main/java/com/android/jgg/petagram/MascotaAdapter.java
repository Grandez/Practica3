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


        final Mascota mascota = mascotas.get(position);
        holder.mFoto.setImageResource(mascota.getImg());
        holder.mNombre.setText(mascota.getNombre());
        holder.mRating.setText(mascota.getRatingAsString());

        MascotaViewHolder.mLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                MascotaService srv = MascotaService.getInstance();
                Toast.makeText(v.getContext(), "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();
                srv.incRating(mascota.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView mNombre;
        TextView mRating;
        ImageView mFoto;
        static ImageButton mLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            // cv = (CardView) findViewById(R.id.cv_mascota);
            mNombre = itemView.findViewById(R.id.mNombre);
            mRating = itemView.findViewById(R.id.mRating);
            mFoto   = (ImageView) itemView.findViewById(R.id.mFoto);
            mLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
