package com.example.carolinapazmorales.appmovilventas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccesoRegistro extends AppCompatActivity {

    Button btregemp, btregven, btGoogleM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso_registro);
        btregemp = (Button) findViewById(R.id.btregemp);
        btregven = (Button) findViewById(R.id.btregven);
        btGoogleM = (Button) findViewById(R.id.bGoogleM);


        btregemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(AccesoRegistro.this, RegistroVenta.class));
            }
        });
        btregven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(AccesoRegistro.this, VerificacionCompra.class));
            }
        });


    }
}