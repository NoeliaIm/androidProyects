package com.noeliaiglesias.intentbuscar;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity  extends AppCompatActivity {
    Button btn;
    TextView tvBuscar;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        btn = (Button)findViewById(R.id.button1);
        tvBuscar = findViewById(R.id.tvBuscar);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                // Se devuelve un Intent impl�cito que nos permite
                // realizar la b�squeda de la palabra que ha introducido el usuario
                String busqueda = tvBuscar.getText().toString();

                Intent in = new Intent(Intent.ACTION_WEB_SEARCH);
                in.putExtra(SearchManager.QUERY, busqueda);
                startActivity(in, in.getExtras());
                //Intent in = new Intent(SecondActivity.this, MainActivity.class);
               // setResult(RESULT_OK, in);
               // finish();
            }




        });

    }
}
