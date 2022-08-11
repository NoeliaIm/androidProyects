package com.noeliaiglesias.persistenceprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UsuariosSQLiteHelper usuariosBD;
    SQLiteDatabase bd;
    EditText edCod, edNom, edAp;
    Button btnListar, btnBorrar, btnModificar, btnInsertar;
    ListView listado;
    int posicion=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuariosBD = new UsuariosSQLiteHelper(this, "DBUsuarios",null,1);
        bd=usuariosBD.getWritableDatabase();
        edCod=findViewById(R.id.edtCodigo);
        edNom=findViewById(R.id.edtNom);
        edAp=findViewById(R.id.edtAp);
        listado=(ListView) findViewById(R.id.list1);
        btnListar = findViewById(R.id.btnListar);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnModificar = findViewById(R.id.btnModificar);
    }

    public void insertar(View v){
        String cod=edCod.getText().toString();
        int cod2 = Integer.parseInt(cod);
        String nombre=edNom.getEditableText().toString();
        String ap=edAp.getEditableText().toString();
        bd.execSQL("INSERT INTO usuarios (codigo,nombre, apellido) VALUES ("+ cod2 +", '"+ nombre +"', '"+ ap+"')");
    }
    public void listar(View v){
        ArrayList<String> l=new ArrayList<String>();
        Cursor miCursor = bd.rawQuery("SELECT codigo, nombre, apellido FROM usuarios", null);
        if (miCursor.moveToFirst()){
            do{
                String codigo= miCursor.getString(0);
                String nombre = miCursor.getString(1);
                String apellido= miCursor.getString(2);
                l.add(codigo+"-" +nombre+"-" +apellido);
            }while(miCursor.moveToNext());
        }
        miCursor.close();
        ArrayAdapter<String> adaptador = new
                ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,l);
        listado.setAdapter(adaptador);
        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                posicion=position;

            }
        });
    }
    public void borrar(View v){

        int cod3 = 33;
        String [] args = {Integer.toString(cod3)};

        //bd.execSQL("DELETE FROM usuarios where codigo="+cod3+";");
        bd.delete("usuarios","codigo=?", args);

    }
    public void modificar(View v){

    }
}