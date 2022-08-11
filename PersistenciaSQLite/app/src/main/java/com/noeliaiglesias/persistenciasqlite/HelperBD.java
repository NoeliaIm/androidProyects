package com.noeliaiglesias.persistenciasqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class HelperBD  extends SQLiteOpenHelper {
    public static final int DB_VERSION=1;
    public static final String DB_NOMBRE= "libros.db";

    public HelperBD(Context context){
        super(context, DB_NOMBRE, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Schema.NOMBRE_TABLA + " ("
                + Schema._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Schema.TITULO + " TEXT,"
                + Schema.AUTOR + " TEXT,"
                + Schema.FECHA + " TEXT"
                + ");";
       // create table libros id autoincrement primary_key , titulo varchar(250), autor varchar(250)
        db.execSQL(sql);

    }

    private static ContentValues getContentValues(Libro libro){
        ContentValues values = new ContentValues();
        values.put(Schema.TITULO, libro.getTitulo()); //string del campo título
        values.put(Schema.AUTOR, libro.getAutor());
        values.put(Schema.FECHA, LocalDate.now().toString());
        return values;
    }

    public void insertarLibro(Libro libro){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = getContentValues(libro);
        //String sql= "INSERT INTO "+ Schema.NOMBRE_TABLA+ " "+ Schema.TITULO +" "+ libro.getTitulo() +"";
        db.insert(Schema.NOMBRE_TABLA, null, values);
    }

    public ArrayList listaDeLibros(){
        ArrayList listaDeLibros = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(Schema.NOMBRE_TABLA, null, null, null, null, null, Schema._ID + " DESC");
        while(cursor.moveToNext()){
            Libro libro = new Libro();
            libro.setId(cursor.getInt(0));
            libro.setTitulo(cursor.getString(1));
            libro.setAutor(cursor.getString(2));
            listaDeLibros.add(libro);
        }
        db.close();
        return listaDeLibros;
    }

    public void editarLibro(Libro libro){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = getContentValues(libro);
        String [] args = {Integer.toString(libro.getId())};
       db.update(Schema.NOMBRE_TABLA, values, "_id =?", args);
        /*SQLiteStatement statement = db.compileStatement("UPDATE " + Schema.NOMBRE_TABLA +
                " SET " + Schema.TITULO + " =?," + Schema.AUTOR + " =?"  + "WHERE " + Schema._ID + " =?");
        statement.bindString(1, libro.getTitulo());
        statement.bindString(2, libro.getAutor());
        statement.bindString(3, Integer.toString(libro.getId()));
        statement.execute();*/
        db.close();
    }

    public void borrarLibro(Libro libro){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = getContentValues(libro);
        String [] args = {Integer.toString(libro.getId())};
        db.delete(Schema.NOMBRE_TABLA, "_id =?", args);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Schema.NOMBRE_TABLA);
        onCreate(db);
    }
}
