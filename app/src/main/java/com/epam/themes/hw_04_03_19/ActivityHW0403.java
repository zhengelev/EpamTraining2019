package com.epam.themes.hw_04_03_19;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.epam.cleancodetest.R;


public class ActivityHW0403 extends AppCompatActivity {

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activityhw0403);



        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentViewHW, new Fragment_hw())
                .commit();
    }

}
