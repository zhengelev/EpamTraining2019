package com.epam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;

import com.epam.cleancodetest.R;

public class VKHomewok extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_vk_hw);
        Toolbar toolbarVK=(Toolbar)findViewById(R.id.toolbar_vk);
        setSupportActionBar(toolbarVK);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu_vk,menu);
        return true;
    }
}
