package com.android.jgg.practica3_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.*;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            Contacto contacto = extras.getParcelable("contacto");
            cargaPantalla(contacto);
        }

    }

    public void btnOK_onClick(View v) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);

        Contacto contacto = creaContacto();
        intent.putExtra("contacto", contacto);
        startActivity(intent);

    }

    private void cargaPantalla(Contacto contacto) {
        EditText text = (EditText) findViewById(R.id.txtNombre);
        text.setText(contacto.getName());
        text = (EditText) findViewById(R.id.txtTfno);
        text.setText(contacto.getTfno());
        text = (EditText) findViewById(R.id.txtMail);
        text.setText(contacto.getMail());
        text = (EditText) findViewById(R.id.txtDesc);
        text.setText(contacto.getDesc());

        DatePicker  dt = (DatePicker) findViewById(R.id.datePicker);
        Date d = contacto.getFecha();
        dt.updateDate(d.getYear(), d.getMonth(), d.getDay());
    }

    private Contacto creaContacto() {
        Contacto contacto = new Contacto();

        EditText text = (EditText) findViewById(R.id.txtNombre);
        contacto.setName(text.getText().toString());

        text = (EditText) findViewById(R.id.txtTfno);
        contacto.setTfno(text.getText().toString());

        text = (EditText) findViewById(R.id.txtMail);
        contacto.setMail(text.getText().toString());

        text = (EditText) findViewById(R.id.txtDesc);
        contacto.setDesc(text.getText().toString());

        DatePicker  dt = (DatePicker) findViewById(R.id.datePicker);
        contacto.setFecha(new Date(dt.getYear() - 1900, dt.getMonth(), dt.getDayOfMonth()));

        return contacto;
    }

}
