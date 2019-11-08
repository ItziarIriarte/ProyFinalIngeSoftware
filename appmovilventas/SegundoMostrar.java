package com.example.carolinapazmorales.appmovilventas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SegundoMostrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_mostrar);

        cargar2();
    }


        private void cargar2 () {

            SegundaBasedeDatos basedeDatos = new SegundaBasedeDatos(this, "DEMODB", null, 1);
            SQLiteDatabase db = basedeDatos.getWritableDatabase();
            if (db != null) {
                Cursor c = db.rawQuery("select * from VerificacionCompra", null);
                int cantidad = c.getCount();
                int i = 0;
                String[] arreglo = new String[cantidad];
                if (c.moveToFirst()) {
                    do {
                        String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2);
                        ;
                        arreglo[i] = linea;
                        i++;
                    } while (c.moveToNext());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arreglo);
                ListView lista = (ListView) findViewById(R.id.Verdatos);
                lista.setAdapter(adapter);
            }
        }
    }


