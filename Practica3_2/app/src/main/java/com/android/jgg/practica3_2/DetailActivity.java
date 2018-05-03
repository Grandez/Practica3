package com.android.jgg.practica3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle extras = getIntent().getExtras();
        Contacto contacto = extras.getParcelable("contacto");
        cargaPantalla(contacto);
    }

    public void btnEdit_onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void cargaPantalla(Contacto contacto) {
        TextView text = (TextView) findViewById(R.id.tvNombre);
        text.setText(contacto.getName());
        text = (TextView) findViewById(R.id.tvMail);
        text.setText(contacto.getMail());
        text = (TextView) findViewById(R.id.tvTfno);
        text.setText(contacto.getTfno());
        text = (TextView) findViewById(R.id.tvDesc);
        text.setText(contacto.getDesc());

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        text = (TextView) findViewById(R.id.tvFecha);
        text.setText(format.format(contacto.getFecha()));

    }

}
