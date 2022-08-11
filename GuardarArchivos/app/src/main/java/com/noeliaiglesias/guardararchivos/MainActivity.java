package com.noeliaiglesias.guardararchivos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button btnGuardar, btnRecuperar, btnGuardarExt, btnRecuperarExt ;
    TextView edtEscribir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGuardar = findViewById(R.id.btnGuardar);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        edtEscribir = findViewById(R.id.edtEscribir);
        btnGuardarExt = findViewById(R.id.btnGuardarExt);
        btnRecuperarExt = findViewById(R.id.btnRecuperarExt);

    }

    public void guardarTexto(View v){

        Toast.makeText(this, "guardar", Toast.LENGTH_LONG).show();
        try
        {
            OutputStreamWriter outputStreamWriter=
                    new OutputStreamWriter(
                            openFileOutput("prueba.txt", Context.MODE_PRIVATE));
            String texto = edtEscribir.getText().toString();

            outputStreamWriter.write(texto);
            outputStreamWriter.close();
            edtEscribir.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void recuperarTexto(View v){
        Toast.makeText(this, "recuperar", Toast.LENGTH_LONG).show();

        try
        {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("prueba.txt")));

            String texto = fin.readLine();
            edtEscribir.setText(texto);
            Log.i("ddd",texto);
            fin.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void guardarTextoExt(View v){
        Toast.makeText(this, "guardarExt", Toast.LENGTH_LONG).show();
        try
        {
            File ruta = Environment.getExternalStorageDirectory();
            File file = new File(ruta.getAbsolutePath(), "prueba.txt");

            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(
                            new FileOutputStream(file));

            String texto = edtEscribir.getText().toString();
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
            edtEscribir.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void recuperarTextoExt(View v){
        Toast.makeText(this, "recuperarExt", Toast.LENGTH_LONG).show();
        try
        {
            File ruta = Environment.getExternalStorageDirectory();

            File file = new File(ruta.getAbsolutePath(), "prueba.txt");

            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(file)));

            String texto = bufferedReader.readLine();
            bufferedReader.close();
            edtEscribir.setText(texto);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}