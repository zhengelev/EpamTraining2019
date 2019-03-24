package com.epam;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

public class GooglePodcastsFragmentPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    public GooglePodcastsFragmentPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int pos) {
        Fragment fragment = null;
        if (pos == 0) {
            fragment = new GooglePodcastFragmenetNewEpisodes();
        }

        else if (pos == 1){
            fragment = new GooglePodcastFragmenetNewEpisodes();
        }

        else if (pos == 2){
            fragment = new GooglePodcastFragmenetNewEpisodes();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
