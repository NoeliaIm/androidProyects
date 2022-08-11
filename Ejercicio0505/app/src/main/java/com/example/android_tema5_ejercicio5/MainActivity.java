package com.example.android_tema5_ejercicio5;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    //método que muestra una notificación
    public void notificar (View v){
    	
    	//obtenemos una referencia al servicio de notificaciones
    	String ns = Context.NOTIFICATION_SERVICE;
    	NotificationManager notManager = (NotificationManager)getSystemService(ns);
    	
    	//capturamos las opciones de la notificacion
    	int icono = android.R.drawable.stat_sys_warning;
    	CharSequence texto = "Alerta!";
    	long hora = System.currentTimeMillis();
    	
    	//creamos el objeto notificación
    	Notification notify = new Notification(icono, texto, hora);
    	
    	//capturamos la configuración del intent
    	Context contexto = getApplicationContext();
    	CharSequence titulo = "Mensaje de Alerta";
    	CharSequence desc = "Ejemplo de notificación";
    	
    	//creamos el intent
    	Intent notIntent = new Intent(contexto, MainActivity.class);

    	
    	//creamos el intent pendiente de un evento
    	PendingIntent contIntent = PendingIntent.getActivity(contexto, 0, notIntent, 0);
    	
    	//asignamos el objeto notificación a este intent
    	notify.setLatestEventInfo(contexto, "Mensaje de alerta", 
    									"Ejemplo de notificación", contIntent);
    	
    	//le añadimos un flag para que desaparezca (or a nivel de bit)
    	notify.flags|=Notification.FLAG_AUTO_CANCEL;
    	
    	//enviamos la notificación al objeto Notification Manager
    	notManager.notify(1, notify);
    }
}
