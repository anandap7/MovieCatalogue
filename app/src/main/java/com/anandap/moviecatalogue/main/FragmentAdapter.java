package com.anandap.moviecatalogue.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anandap.moviecatalogue.movies.MoviesFragment;
import com.anandap.moviecatalogue.tvshows.TVShowsFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private String[] navTitle = {"Movies", "TV Shows"};

    FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new MoviesFragment();
                break;
            case 1:
                fragment = new TVShowsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return navTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return navTitle[position];
    }
}
