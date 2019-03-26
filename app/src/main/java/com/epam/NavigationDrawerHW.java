package com.epam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.epam.cleancodetest.R;

public class NavigationDrawerHW extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer_hw);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        menuItem.setChecked(true);
                        selectDrawerItem(menuItem);

                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(menuItem);
    }

    public void selectDrawerItem(MenuItem menuItem){
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.nav_camera:
                fragmentClass=FirstFragmentNavigationDrawer.class;
                break;
            case  R.id.nav_gallery:
                fragmentClass=SecondFragmentNavigationDrawer.class;
                break;
            case R.id.nav_slideshow:
                fragmentClass=ThirdFragmentNavigationDrawer.class;
                break;
                default:
                    fragmentClass=FirstFragmentNavigationDrawer.class;
        }

        try {
            fragment = (Fragment)fragmentClass.newInstance();
        } catch (Exception e){
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.content_frame,fragment)
                .commit();

    }
}
