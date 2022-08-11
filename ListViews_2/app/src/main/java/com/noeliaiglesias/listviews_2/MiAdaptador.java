package com.noeliaiglesias.listviews_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MiAdaptador  extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<String> names;
    public MiAdaptador(Context context, int layout, ArrayList<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;
    }
    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v= layoutInflater.inflate(R.layout.list_item, null);
        // Valor actual según la posición

        String currentName  = names.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView textView = (TextView) v.findViewById(R.id.txtV);
        textView.setText(currentName);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicaste " + currentName, Toast.LENGTH_SHORT).show();

            }
        });
        //Devolvemos la vista inflada
        return v;
    }

}
