package com.noeliaiglesias.persistenciasqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterList extends BaseAdapter {
    private MainActivity activity;
    private ArrayList<Libro> listaLibros;
    private TextView id;

    public AdapterList(MainActivity activity, ArrayList<Libro> items){
        this.activity = activity;
        this.listaLibros= items;
    }

    @Override
    public int getCount() {
        return listaLibros.size();
    }

    @Override
    public Libro getItem(int id) {
        return listaLibros.get(id);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflador = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflador.inflate(R.layout.item, null);
        }
        final Libro libroActual = getItem(position);
         EditText editTitulo = v.findViewById(R.id.edit_titulo);
         EditText editAutor = v.findViewById(R.id.edit_autor);
        id = v.findViewById(R.id.txt_id);
        id.setText(libroActual.getId() + " - ");
        editTitulo.setText(libroActual.getTitulo());
        editAutor.setText(libroActual.getAutor());
        String newTitulo = editTitulo.getEditableText().toString();
        String newAutor = editAutor.getEditableText().toString();
        activity.findViewById(R.id.btnModificar).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                modificar(position, convertView, parent, newTitulo, newAutor);
            }
        });

        activity.findViewById(R.id.btnBorrar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    borrar(position, convertView, parent);
            }
        });
        return v;
    }


    public void modificar(int position, View convertView, ViewGroup parent, String editTitulo, String editAutor){
        final Libro libroActual = getItem(position);
        int id = libroActual.getId();
        Libro libro= new Libro();
        libro.setId(id);
        libro.setTitulo(editTitulo);
        libro.setAutor(editAutor);
        activity.modificar(libro);
    }

    public void borrar(int position, View convertView, ViewGroup parent){
        final Libro libroActual = getItem(position);
        activity.borrar(libroActual);
    }
}
