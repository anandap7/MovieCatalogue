package com.anandap.moviecatalogue.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.model.Movie;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvYear = findViewById(R.id.detail_year);
        TextView tvDirector = findViewById(R.id.detail_director);
        TextView tvCast = findViewById(R.id.detail_cast);
        TextView tvOverview = findViewById(R.id.detail_overview);
        ImageView ivPoster = findViewById(R.id.detail_image);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String sCast = "";
        for (String cast : movie.getCast()) {
            sCast += cast + "\n";
        }
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(movie.getTitle());
        tvYear.setText(movie.getYear());
        tvDirector.setText(movie.getDirector());
        tvCast.setText(sCast);
        tvOverview.setText(movie.getOverview());
        ivPoster.setImageDrawable(getDrawable(movie.getPoster()));
    }
}
