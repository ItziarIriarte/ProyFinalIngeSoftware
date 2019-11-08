package com.example.carolinapazmorales.appmovilventas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button btingresar= (Button) findViewById(R.id.btingresar);
        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario=((EditText) findViewById(R.id.txtUsu1)).getText().toString();
                String pass=((EditText) findViewById(R.id.txtPass)).getText().toString();
                if (usuario.equals("vendedor1")&& pass.equals("ventas1"))


                {
                    startActivity(new Intent(Inicio.this, RegistroVenta.class));
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
