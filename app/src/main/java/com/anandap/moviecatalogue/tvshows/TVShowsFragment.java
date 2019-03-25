package com.anandap.moviecatalogue.tvshows;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anandap.moviecatalogue.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowsFragment extends Fragment {
    RecyclerView recyclerView;
    TvShowAdapter adapter;
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public TVShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);
        recyclerView = view.findViewById(R.id.rv_tv_shows);
        adapter = new TvShowAdapter(getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        tvShows.addAll(TvShowsData.getTvShowList());
        adapter.setTvShows(tvShows);

        recyclerView.setAdapter(adapter);
        return view;
    }

}
