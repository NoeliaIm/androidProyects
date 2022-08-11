package com.noeliaiglesias.pendingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationManager notManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String ns = Context.NOTIFICATION_SERVICE;
        notManager= (NotificationManager)getSystemService(ns);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }


    //método que muestra una notificación
    public void notificar (View v){

        Context ctx= getApplicationContext();

        //creamos el intent
        Intent intentWeb = new Intent();
        intentWeb.setAction(Intent.ACTION_VIEW);
        intentWeb.setData(Uri.parse("https://www.google.es/"));
        // Construct a task stack.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ctx);

        // Add the main Activity to the task stack as the parent.
        stackBuilder.addParentStack(MainActivity.class);

        // Push the content Intent onto the stack.
        stackBuilder.addNextIntent(intentWeb);

        // Get a PendingIntent containing the entire back stack.
        PendingIntent notificationPendingIntent =
                stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.Builder notificationBuilder = new Notification.Builder(ctx)
                .setContentTitle("Titulo")
                .setContentText("Texto")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(notificationPendingIntent);

        notManager.notify(0, notificationBuilder.build());

    }




}