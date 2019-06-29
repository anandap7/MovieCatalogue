package com.anandap.moviecatalogue.favorites.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.anandap.moviecatalogue.favorites.fragment.FavoriteMoviesFragment;
import com.anandap.moviecatalogue.favorites.fragment.FavoriteTvShowsFragment;

public class FavoritesFragmentAdapter extends FragmentPagerAdapter {
    private String[] tabTitle = {"Movies", "TV Shows"};

    FavoritesFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new FavoriteMoviesFragment();
                break;
            case 1:
                fragment = new FavoriteTvShowsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
