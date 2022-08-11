package com.noeliaiglesias.listviews_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList <String> series;
    private ListView listView;
    MiAdaptador miAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        series = new ArrayList<>();
        series.add("Juego de Tronos");
        series.add("Vikingos");
        series.add( "Mr. Robot");
        series.add("Big Bang Theory");
        miAdaptador = new MiAdaptador(this, R.layout.list_item,series);
        listView.setAdapter(miAdaptador);
    }
}


