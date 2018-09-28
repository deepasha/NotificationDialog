package com.example.samsung.reallocation;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.nio.channels.Channel;

import static com.example.samsung.reallocation.app.CHANNEL_1_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager= NotificationManagerCompat.from(this);

    }

    public void sendOnChannel(View view)
    {
        Intent activityIntent =new Intent(this,MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,activityIntent,0);
        Intent broadcastIntent =new Intent(this,NotificationReceiver.class);
        
        broadcastIntent.putExtra("Toastmessage",0);
PendingIntent actionIntent  =PendingIntent.getBroadcast(this,0,broadcastIntent ,PendingIntent.FLAG_UPDATE_CURRENT );

        Notification notification= new NotificationCompat.Builder(this,CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_pin_drop)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .addAction(R.mipmap.ic_launcher,"Toast",actionIntent)
                .build();


           notificationManager.notify(1,notification);

    }
}
