package com.noeliaiglesias.persistenciasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edtTitulo, edtAutor;
    private Button btnInsertar,  btnListar,  btnBorrar, btnModificar;
    private ListView listado;
    private HelperBD helperBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helperBD = new HelperBD(getApplicationContext());
        edtTitulo = findViewById(R.id.edtTitulo);
        edtAutor= findViewById(R.id.edtAutor);
        btnInsertar= findViewById(R.id.btnInsertar);
        btnListar= findViewById(R.id.btnListar);
        btnBorrar= findViewById(R.id.btnBorrar);
        btnModificar= findViewById(R.id.btnModificar);
        listado= findViewById(R.id.lvListado);

    }

    public void insertar(View v){
        Libro libro = new Libro();
        libro.setTitulo(edtTitulo.getEditableText().toString());
        libro.setAutor(edtAutor.getEditableText().toString());
        helperBD.insertarLibro(libro);
        edtTitulo.setText("");
        edtAutor.setText("");
    }

    public void mostrar(View v){

        ArrayList listadoLibros = helperBD.listaDeLibros();
        AdapterList adapter = new AdapterList(this, helperBD.listaDeLibros());
        listado.setAdapter(adapter);
    }



    public void borrar(Libro libro){
        helperBD.borrarLibro(libro);
    }

    public void modificar(Libro libro){
        helperBD.editarLibro(libro);
    }
}