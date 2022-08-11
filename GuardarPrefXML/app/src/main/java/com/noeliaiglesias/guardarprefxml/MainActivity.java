package com.noeliaiglesias.guardarprefxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtNombre, edtEmail;
    Button btnGuardar, btnRecuperar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombre = findViewById(R.id.edtNombre);
        edtEmail = findViewById(R.id.edtEmail);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRecuperar = findViewById(R.id.btnRecuperar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs =
                        getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", edtEmail.getText().toString());
                editor.putString("nombre",edtNombre.getText().toString());
                editor.commit();
                edtEmail.setText("");
                edtNombre.setText("");
            }
        });

btnRecuperar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String nombre = prefs.getString("nombre", "");
        String email = prefs.getString("email", "");
        edtNombre.setText(nombre);
        edtEmail.setText(email);
    }
});

    }


}

 /*   <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
<map>
<string name="nombre">prueba</string>
<string name="email">modificado@email.com</string>
</map>

        /data/data/paquetejava/shared_prefs/nombre_coleccion.xml */