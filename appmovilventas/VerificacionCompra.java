package com.example.carolinapazmorales.appmovilventas;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VerificacionCompra extends AppCompatActivity {

    Button butguardar, butmostrar, bexaminar2;
    private EditText txtUsuario, txtidvend, txtDirven, txtexaminar2;
    private final int PICKER  =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_compra);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtidvend = (EditText) findViewById(R.id.txtidvend);
        txtDirven = (EditText) findViewById(R.id.txtDirven);
        txtexaminar2 = (EditText) findViewById(R.id.txtexaminar2);
        bexaminar2 = (Button) findViewById(R.id.bexaminar2);
        butmostrar = (Button) findViewById(R.id.butmostrar);
        butguardar = (Button) findViewById(R.id.butguardar);





        bexaminar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pickfile();
            }
        });




        butmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(VerificacionCompra.this, SegundoMostrar.class));
            }
        });
    }

    private void Pickfile(){
        Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
        intent. setType("file /*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try{
            startActivityForResult(
                    Intent.createChooser(intent,"seleccione un archivo para subir"),PICKER
            );

        }catch (android.content.ActivityNotFoundException ex){
        }
    }
    protected void onActivityResult (int requestCode , int resultCode, Intent data){
        switch (requestCode) {
            case PICKER:
                if (resultCode== RESULT_OK){
                    String FilePath = data. getData().getPath();
                    txtexaminar2.setText(FilePath);
                }
                break;

        }
    }



    public void GuardarDatos(View view) {
        String usuario1 = txtUsuario.getText().toString();
        String idvend= txtidvend.getText().toString();
        String dirven= txtDirven.getText().toString();
        String examinar2= txtexaminar2.getText().toString();

        SegundaBasedeDatos basedeDatos = new SegundaBasedeDatos(this, "DEMODB", null, 1);

        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo1 = new ContentValues();
            registronuevo1.put("Usuario", usuario1);
            registronuevo1.put("idvend",idvend);
            registronuevo1.put("dirven",dirven);
            registronuevo1.put("examinar2",examinar2);



            db.insert("VerificacionCompra", null, registronuevo1);
            Toast.makeText(this, "Verificacion Correcta", Toast.LENGTH_SHORT).show();
        }
    }
}
