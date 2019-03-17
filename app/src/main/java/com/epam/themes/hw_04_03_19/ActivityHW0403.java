package com.epam.themes.hw_04_03_19;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.epam.cleancodetest.R;

import static com.epam.themes.hw_04_03_19.ServiceHW.Result;


public class ActivityHW0403 extends AppCompatActivity {

    private static final String BroadCastAction = "com.epam.CUSTOM_ACTION";
    private Button startServiceButton;
    private Button stopServiceButton;
    private TextView BroadcastMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityhw0403);

        startServiceButton = findViewById(R.id.startService);
        stopServiceButton = findViewById(R.id.stopService);
        BroadcastMessage = findViewById(R.id.broadcastMessage);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentViewHW, new Fragment_hw())
                .commit();

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(ActivityHW0403.this,ServiceHW.class));
            }
        });
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(ActivityHW0403.this,ServiceHW.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver,new IntentFilter(BroadCastAction));
    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(myReceiver);
    }
    private BroadcastReceiver myReceiver = new BroadcastReceiver(){
        public void onReceive(Context context,Intent intent){
            Bundle bundle = intent.getExtras();
            if (bundle!=null){
                BroadcastMessage.setText(bundle.getString(Result));
            }
        }
    };
}