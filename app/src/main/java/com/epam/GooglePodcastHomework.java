package com.epam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.epam.cleancodetest.R;

public class GooglePodcastHomework extends AppCompatActivity {

    private ViewPager cardViewPager;
    private GooglePodcastsFragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.google_podcast_hw);

        cardViewPager=findViewById(R.id.view_pager);
        fragmentPagerAdapter= new GooglePodcastsFragmentPagerAdapter(getSupportFragmentManager());
        cardViewPager.setAdapter(fragmentPagerAdapter);
    }
}
