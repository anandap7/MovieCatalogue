package com.anandap.moviecatalogue.movies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anandap.moviecatalogue.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {
    RecyclerView recyclerView;
    MovieAdapter adapter;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        recyclerView = view.findViewById(R.id.rv_movies);
        adapter = new MovieAdapter(getContext());

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        movies.addAll(MoviesData.getMovieList());
        adapter.setMovies(movies);

        recyclerView.setAdapter(adapter);

        return view;
    }

}
