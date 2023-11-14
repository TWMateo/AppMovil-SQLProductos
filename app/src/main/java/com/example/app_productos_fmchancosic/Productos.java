package com.example.app_productos_fmchancosic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class Productos {
    private AdminSQL sql;

    public Productos(@Nullable Context context, @Nullable String name, int version){
        sql = new AdminSQL(context, name, null, version);
    }
    //Create
    public Producto Create(int id, String descripcion, int stock, double precio_unitario, double tasa_iva){
        SQLiteDatabase bdd = sql.getWritableDatabase();
        ContentValues item = new ContentValues();
        item.put("id",id);
        item.put("descripcion",descripcion);
        item.put("stock",stock);
        item.put("precio_unitario",precio_unitario);
        item.put("tasa_iva",tasa_iva);
        bdd.insert("productos",null,item);
        Producto p = new Producto();
        p.Id = id;
        p.Descripcion = descripcion;
        p.Stock = stock;
        p.Precio_unitario = precio_unitario;
        p.Tasa_iva = tasa_iva;
        return null;
    }
    //Read
    public Producto Read_ById(int id){
        SQLiteDatabase bdd = sql.getReadableDatabase();
        Cursor data = bdd.rawQuery("SELECT id, descripcion,stock,precio_unitario,tasa_iva FROM productos WHERE id="+id,null);
        if(data.getCount()>0){
            data.moveToFirst();
            Producto p= new Producto();
            p.Id = data.getInt(0);
            p.Descripcion = data.getString(1);
            p.Stock = data.getInt(2);
            p.Precio_unitario = data.getDouble(3);
            p.Tasa_iva = data.getDouble(4);
            return p;
        }else
            return null;
    }
    //Update
    public void Update(int id, String descripcion, int stock, double precio_unitario, double tasa_iva){
        SQLiteDatabase bdd = sql.getWritableDatabase();
        ContentValues item = new ContentValues();
        item.put("id",id);
        item.put("descripcion",descripcion);
        item.put("stock",stock);
        item.put("precio_unitario",precio_unitario);
        item.put("tasa_iva",tasa_iva);
        bdd.update("productos",item,"id"+id,null);
    }
    //Delete
    public void Delete(int id){
        SQLiteDatabase bdd = sql.getWritableDatabase();
        bdd.delete("productos","id="+id,null);
    }
}
