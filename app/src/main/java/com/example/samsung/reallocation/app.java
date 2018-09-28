package com.example.samsung.reallocation;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/**
 * Created by Samsung on 9/27/2018.
 */

public class app extends Application {

    public static final String CHANNEL_1_ID = "GPS ON";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "gps on",
                    NotificationManager.IMPORTANCE_HIGH


            );
            channel1.setDescription("gps is on ");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);

        }

    }
}