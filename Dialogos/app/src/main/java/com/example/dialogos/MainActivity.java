package com.example.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageButton btnStar, btnDialogQuestion;
    Dialog dialogo;
    Button btnAlertDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStar= findViewById(R.id.ibtnStar);
        //instanciamos el dialogo
        dialogo = crearDialogo();
        btnAlertDialogo = findViewById(R.id.btnAlertDialogo);
        btnDialogQuestion = findViewById(R.id.btnDialogQuestion);
        //lanzamos el dialogo
       // dialogo.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    //método que crea un cuadro de diálogo
    private Dialog crearDialogo (){

        //creamos un objeto Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //ponemos el encabezado del dialogo
        builder.setTitle("Importante");

        //ponemos el mensaje
        //builder.setMessage("Este es una versión de prueba y no el programa completo!");
        final String[] items ={"Español", "Inglés", "Francés"};

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
               Toast.makeText(getApplicationContext(), "Has clicado "+ items[item], Toast.LENGTH_LONG).show();
            }
        });

        //devolvemos el dialogo creado
        return builder.create();
    }

    public void mostrarDialogo(View v){
         dialogo.show();
    }

    public void alertDialogo(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("EJEMPLO DE DIALOLGO")
                .setTitle("TÍTULO DEL DIÁLOGO")
                .setIcon(android.R.drawable.ic_dialog_alert);

        AlertDialog dialogo = builder.create();
        dialogo.show();
    }

    public void alertDialogoOpciones(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Deseas recibir nuestras novedades?")
                .setTitle("SUSCRIPCIÓN")
                .setIcon(android.R.drawable.ic_dialog_email)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showToast("Pulsas la opción DERECHA (SI).");
                        dialog.cancel();
                    }
                })
                .setNeutralButton("Recordar más tarde", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showToast("Pulsas la opción NEUTRA (RECORDAR MÁS TARDE).");
                        dialog.cancel();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        showToast("Pulsas la opción IZQUIERDA (NO).");
                        dialog.cancel();
                    }
                }).show();

    }

    public void showToast(String mnsj) {
        Toast toast = Toast.makeText(getApplicationContext(), mnsj, Toast.LENGTH_SHORT);
        toast.show();
    }
}