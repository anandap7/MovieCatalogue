package com.anandap.moviecatalogue.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.movies.Movie;
import com.anandap.moviecatalogue.tvshows.TvShow;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvYear = findViewById(R.id.detail_year);
        TextView tvDirectorLabel = findViewById(R.id.label_director);
        TextView tvDirector = findViewById(R.id.detail_director);
        TextView tvCast = findViewById(R.id.detail_cast);
        TextView tvOverview = findViewById(R.id.detail_overview);
        ImageView imgPoster = findViewById(R.id.detail_image);

        if (getIntent().getParcelableExtra(EXTRA_MOVIE) != null) {
            tvDirectorLabel.setText(getResources().getString(R.string.director_label));
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(movie.getTitle());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            tvYear.setText(movie.getYear());
            tvDirector.setText(movie.getDirector());
            tvCast.setText(movie.getCast());
            tvOverview.setText(movie.getOverview());
            Glide.with(this)
                    .load(movie.getPoster())
                    .apply(new RequestOptions().override(200, 300))
                    .into(imgPoster);
        } else if (getIntent().getParcelableExtra(EXTRA_TV_SHOW) != null) {
            tvDirectorLabel.setText(getResources().getString(R.string.creator_label));
            TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(tvShow.getTitle());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            tvYear.setText(tvShow.getYear());
            tvDirector.setText(tvShow.getCreator());
            tvCast.setText(tvShow.getCast());
            tvOverview.setText(tvShow.getOverview());
            Glide.with(this)
                    .load(tvShow.getPoster())
                    .apply(new RequestOptions().override(200, 300))
                    .into(imgPoster);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
