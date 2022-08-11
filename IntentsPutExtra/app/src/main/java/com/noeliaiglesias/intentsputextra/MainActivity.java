package com.noeliaiglesias.intentsputextra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Localizar los controles
        final EditText txtNombre = (EditText)findViewById(R.id.TxtNombre);

        final Button btnHola = (Button)findViewById(R.id.BtnHola);
        btnHola.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //Creamos el Intent
                Intent intent = new Intent(MainActivity.this, Saludo.class);

                //Creamos la informaci�n a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", txtNombre.getText().toString());

                //A�adimos la informaci�n al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }
}