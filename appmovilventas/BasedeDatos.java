package com.example.carolinapazmorales.appmovilventas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BasedeDatos extends SQLiteOpenHelper{


    String tabla= "CREATE TABLE RegistroVenta(Id INTEGER PRIMARY KEY AUTOINCREMENT, descripcion Text, examinar Text)";

    public BasedeDatos (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
