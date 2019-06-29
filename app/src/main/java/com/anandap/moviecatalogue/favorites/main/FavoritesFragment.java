package com.anandap.moviecatalogue.favorites.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anandap.moviecatalogue.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        viewPager = view.findViewById(R.id.view_pager_favorites);
        tabLayout = view.findViewById(R.id.tab_favorites);

        tabLayout.setTabTextColors(
                ContextCompat.getColor(getActivity(), R.color.grey400),
                ContextCompat.getColor(getActivity(), android.R.color.white)
        );

        viewPager.setAdapter(new FavoritesFragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

}
