package com.example.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.concurrent.ExecutionException;

public class DBContactos extends DBHelper{
    Context context;

    public DBContactos(@Nullable Context context){
        super(context);
        this.context=context;
    }


    public long insertarContacto(String nombre, String telefono, String correo) {
        long id =0;
        try{
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo", correo);
            id = db.insert(TABLE_CONTACTOS, null,values);

        }catch(Exception ex){
            ex.toString();
        }
        return id;

    }
}
