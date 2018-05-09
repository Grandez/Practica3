package com.android.jgg.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.GestureDetector;
import android.view.MotionEvent;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Mascota> mascotas;
    private RecyclerView lstMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MascotaService mascotaSrv = MascotaService.getInstance();
        mascotas = mascotaSrv.getMascotas();


        lstMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        lstMascotas.setLayoutManager(llm);

        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        lstMascotas.setAdapter(adapter);

    }

    public void incRating(View v) {

    }
    public void showRating(View v) {
        Intent intent = new Intent(this, RatingActivity.class);
        startActivity(intent);
    }
}
