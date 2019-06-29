package com.anandap.moviecatalogue.favorites.fragment;


import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.db.TvShowHelper;
import com.anandap.moviecatalogue.favorites.FavoriteTvShowsAdapter;
import com.anandap.moviecatalogue.tvshows.TvShow;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteTvShowsFragment extends Fragment {
    private FavoriteTvShowsAdapter adapter;
    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private TvShowHelper tvShowHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_tv_shows, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_fav_tv_shows);
        adapter = new FavoriteTvShowsAdapter(getContext());
        tvShowHelper = TvShowHelper.getInstance(getContext());

        recyclerView.setHasFixedSize(true);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        recyclerView.setAdapter(adapter);

        if (savedInstanceState != null) {
            tvShows = savedInstanceState.getParcelableArrayList("list");
            adapter.setTvShows(tvShows);
            adapter.notifyDataSetChanged();
        } else retrieveData();
        return view;
    }

    private void retrieveData() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle(getResources().getString(R.string.loading));
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        tvShows.clear();
        tvShows.addAll(tvShowHelper.getAllTvShows());
        adapter.setTvShows(tvShows);
        adapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("list", tvShows);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }
}
