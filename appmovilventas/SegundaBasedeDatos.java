package com.example.carolinapazmorales.appmovilventas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SegundaBasedeDatos extends SQLiteOpenHelper {

    String tabla2= "CREATE TABLE VerificacionCompra(Id INTEGER PRIMARY KEY AUTOINCREMENT, Usuario  Text, idvend Text, Dirven Text, examinar2 Text)";

    public SegundaBasedeDatos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
      super(context, name, factory, version);
   }
    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla2);
   }

    @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}