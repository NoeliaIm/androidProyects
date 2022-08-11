package com.noeliaiglesias.persistenceprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {
    private final String NOMBRE_TABLA ="usuarios";
    private final String COLUMNA_CODIGO ="codigo";
    private final String COLUMNA_NOMBRE = "nombre";
    private final String COLUMNA_APELLIDO = "apellido";
    String sql = "CREATE TABLE " + NOMBRE_TABLA + " ("
            + COLUMNA_CODIGO + " INTEGER,"
            + COLUMNA_NOMBRE + " TEXT,"
            + COLUMNA_APELLIDO + " TEXT"
            + ");";

    //String sqlCreate = "CREATE TABLE usuarios (codigo INTEGER, nombre TEXT, apellido TEXT);";
    public UsuariosSQLiteHelper (Context context, String nom,
                                 SQLiteDatabase.CursorFactory factory, int vers){
        super(context, nom,factory, vers);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva){
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL(sql);
    }
}