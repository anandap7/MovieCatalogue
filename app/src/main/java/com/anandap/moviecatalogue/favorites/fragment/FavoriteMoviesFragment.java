package com.anandap.moviecatalogue.favorites.fragment;


import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.db.MovieHelper;
import com.anandap.moviecatalogue.favorites.FavoriteMoviesAdapter;
import com.anandap.moviecatalogue.movies.Movie;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteMoviesFragment extends Fragment {
    private FavoriteMoviesAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();
    private MovieHelper movieHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite_movies, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_fav_movies);
        adapter = new FavoriteMoviesAdapter(getContext());
        movieHelper = MovieHelper.getInstance(getContext());

        recyclerView.setHasFixedSize(true);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT)
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        else if (orientation == Configuration.ORIENTATION_LANDSCAPE)
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        if (savedInstanceState != null) {
            movies = savedInstanceState.getParcelableArrayList("list");
            adapter.setMovies(movies);
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

        movies.clear();
        movies.addAll(movieHelper.getAllMovies());
        adapter.setMovies(movies);
        adapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelableArrayList("list", movies);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        retrieveData();
    }
}
