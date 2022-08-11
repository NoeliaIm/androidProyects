package com.noeliaiglesias.intentbuscar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    static final int ActivityID = 1111;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Lanza una actividad de la que quiere saber el resultado
                // Intent explicito
                // Log.i("PRIMERA_ACTIVIDAD","Pulsa boton. Lanza segunda actividad");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //startActivityForResult(intent, 1111);
                startActivity(intent);
                //}
            }





        });


    }


    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111) {
            // Si el resultado es OK, lanza una actividad de la que no quiere saber el resultado
            if (resultCode == RESULT_OK) {
                startActivity(data);
            }
        }

    }
}