package com.anandap.moviecatalogue.tvshows;


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
import com.anandap.moviecatalogue.api.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    RecyclerView recyclerView;
    TvShowAdapter adapter;
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tvshows, container, false);
        recyclerView = view.findViewById(R.id.rv_tv_shows);
        adapter = new TvShowAdapter(getContext());

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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("list", tvShows);
    }

    void retrieveData() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle(getResources().getString(R.string.loading));
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        Call<TvShows> call = ApiClient.create().getTvShows("189e40dd8f626cd7f35fed458fe7c0ef");
        call.enqueue(new Callback<TvShows>() {
            @Override
            public void onResponse(Call<TvShows> call, Response<TvShows> response) {
                tvShows.addAll(response.body().getResults());
                adapter.setTvShows(tvShows);
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<TvShows> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
