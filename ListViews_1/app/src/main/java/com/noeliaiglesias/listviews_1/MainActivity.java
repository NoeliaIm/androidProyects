package com.noeliaiglesias.listviews_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listado = (ListView) findViewById(R.id.list_view);
        TextView preferida = findViewById(R.id.txt_elegido);
        final String[] datos = new String[]{"Juego de Tronos",
                "Vikingos",
                "Mr. Robot",
                "Big Bang Theory"};
        ArrayAdapter<String> adaptador = new
                ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        listado.setAdapter(adaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id){
                //obtener el texto del elemento que se ha pulsado

                String seleccionado = (String) parent.getItemAtPosition(posicion);
                preferida.setText("La serie preferida elegida es " + seleccionado);
            }
        });

    }


}