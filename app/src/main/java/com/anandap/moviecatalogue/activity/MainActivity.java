package com.anandap.moviecatalogue.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.adapter.MovieAdapter;
import com.anandap.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
	private String[] dataTitle, dataYear, dataDirector, dataOverview;
	private TypedArray dataCast, dataPoster;
	private MovieAdapter adapter;
	private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
		adapter = new MovieAdapter(this);
		listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE ,movies.get(position));
                startActivity(intent);
            }
        });
    }
	
	private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataTitle[i]);
            movie.setYear(dataYear[i]);
            movie.setDirector(dataDirector[i]);
            movie.setOverview(dataOverview[i]);
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setCast(getResources().getStringArray(dataCast.getResourceId(i, -1)));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.title);
        dataYear = getResources().getStringArray(R.array.year);
        dataDirector = getResources().getStringArray(R.array.director);
        dataOverview = getResources().getStringArray(R.array.overview);
        dataPoster = getResources().obtainTypedArray(R.array.poster);
        dataCast = getResources().obtainTypedArray(R.array.cast);
    }
}
