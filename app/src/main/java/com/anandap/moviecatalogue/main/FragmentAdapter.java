package com.anandap.moviecatalogue.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anandap.moviecatalogue.favorites.main.FavoritesFragment;
import com.anandap.moviecatalogue.movies.MoviesFragment;
import com.anandap.moviecatalogue.tvshows.TvShowsFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    private String[] navTitle = {"Movies", "TV Shows", "Favorites"};

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
                fragment = new TvShowsFragment();
                break;
            case 2:
                fragment = new FavoritesFragment();
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
