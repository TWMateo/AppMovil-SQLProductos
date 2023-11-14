package com.example.app_productos_fmchancosic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQL extends SQLiteOpenHelper {
    //Constructor generado por el IDE
    public AdminSQL(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    //Metodo para la creacion de la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS productos(id int PRIMARY KEY, descripcion TEXT(50), stock number(10,3),precio_unitario number(10,3), tasa_iva number(10,3))");
    }
    //Método para la actualización de BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
