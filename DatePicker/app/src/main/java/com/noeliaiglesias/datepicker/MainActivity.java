package com.noeliaiglesias.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private static final String CERO = "0";
    private static final String BARRA = "/";

    Button btnFecha;
    String miFecha ="";
    EditText etFecha;

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFecha= findViewById(R.id.btnFecha);
        btnFecha.setOnClickListener(this);
        etFecha = (EditText) findViewById(R.id.editText);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnFecha:
                obtenerFecha();
                break;
        }

    }

    private void obtenerFecha(){
        //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
/**
 *También puede cargar los valores que usted desee
 */
        DatePickerDialog recogerFecha = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
            final int mesActual = month + 1;
            //Formateo el día obtenido: antepone el 0 si son menores de 10
            String diaFormateado = (dayOfMonth < 10)? CERO + (dayOfMonth):String.valueOf(dayOfMonth);
            //Formateo el mes obtenido: antepone el 0 si son menores de 10
            String mesFormateado = (mesActual < 10)? CERO + (mesActual):String.valueOf(mesActual);
            //Muestro la fecha con el formato deseado
            miFecha =diaFormateado + BARRA + mesFormateado + BARRA + year;
            Log.i("Fecha", miFecha);
            etFecha.setText(miFecha);
        },anio, mes, dia);

        //Muestro el widget
        recogerFecha.show();
       //Toast.makeText(this, miFecha, Toast.LENGTH_LONG).show();
    }


}