package com.epam.themes.hw_04_03_19;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class ServiceHW extends Service {
    public static final String Result = "Broadcast message";
    private String messageToBroadcastReceiver="Here is your message";
    private Intent Broadcast = new Intent("com.epam.CUSTOM_ACTION");

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service was started", Toast.LENGTH_LONG).show();

        Broadcast.putExtra(Result,messageToBroadcastReceiver);
        sendBroadcast(Broadcast);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"Service was stopped", Toast.LENGTH_LONG).show();
    }
}
