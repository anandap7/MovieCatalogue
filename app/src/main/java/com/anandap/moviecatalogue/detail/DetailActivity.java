package com.anandap.moviecatalogue.detail;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.db.MovieHelper;
import com.anandap.moviecatalogue.db.TvShowHelper;
import com.anandap.moviecatalogue.movies.Movie;
import com.anandap.moviecatalogue.tvshows.TvShow;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    private TextView tvOverview;
    private boolean isFavorite = false;
    private Menu menuItem = null;
    private MovieHelper movieHelper;
    private Movie movie = null;
    private TvShowHelper tvShowHelper;
    private TvShow tvShow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvDate = findViewById(R.id.detail_date);
        TextView tvRatingLabel = findViewById(R.id.label_rating);
        TextView tvRating = findViewById(R.id.detail_rating);
        tvOverview = findViewById(R.id.detail_overview);
        ImageView imgPoster = findViewById(R.id.detail_image);

        movieHelper = MovieHelper.getInstance(getApplicationContext());
        tvShowHelper = TvShowHelper.getInstance(getApplicationContext());

        if (getIntent().getParcelableExtra(EXTRA_MOVIE) != null)
            movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        else if (getIntent().getParcelableExtra(EXTRA_TV_SHOW) != null)
            tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getResources().getString(R.string.loading));
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (movie != null) {
            tvRatingLabel.setText(getResources().getString(R.string.rating_label));
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(movie.getTitle());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            try {
                Date date = sdf.parse(movie.getRelease_date());
                sdf.applyPattern("dd MMM yyyy");
                tvDate.setText(sdf.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tvRating.setText(movie.getRating());
            tvOverview.setText(movie.getOverview());
            Glide.with(this)
                    .load(movie.getPoster())
                    .apply(new RequestOptions().override(200, 300))
                    .into(imgPoster);
            progressDialog.dismiss();
        } else if (tvShow != null) {
            tvRatingLabel.setText(getResources().getString(R.string.rating_label));
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(tvShow.getTitle());
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
            try {
                Date date = sdf.parse(tvShow.getFirst_air_date());
                sdf.applyPattern("dd MMM yyyy");
                tvDate.setText(sdf.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            tvRating.setText(tvShow.getRating());
            tvOverview.setText(tvShow.getOverview());
            Glide.with(this)
                    .load(tvShow.getPoster())
                    .apply(new RequestOptions().override(200, 300))
                    .into(imgPoster);
            progressDialog.dismiss();
        }

        favoriteState();
    }

    private void setFavorite() {
        if (isFavorite)
            menuItem.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_favorited));
        else
            menuItem.getItem(0).setIcon(ContextCompat.getDrawable(this, R.drawable.ic_unfavorited));
    }

    private void favoriteState() {
        if (movie != null && movieHelper.findMovie(movie.getId()) > 0) {
            isFavorite = true;
        } else if (tvShow != null && tvShowHelper.findTvShow(tvShow.getId()) > 0) {
            isFavorite = true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite, menu);
        menuItem = menu;
        setFavorite();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.add_to_favorite) {
            if (isFavorite) {
                if (movie != null) movieHelper.deleteMovie(movie.getId());
                else if (tvShow != null) tvShowHelper.deleteTvShow(tvShow.getId());
                Snackbar.make(tvOverview, getString(R.string.remove_from_favorite), Snackbar.LENGTH_LONG).show();
            } else {
                if (movie != null) movieHelper.insertMovie(movie);
                else if (tvShow != null) tvShowHelper.insertTvShow(tvShow);
                Snackbar.make(tvOverview, getString(R.string.add_to_favorite), Snackbar.LENGTH_LONG).show();
            }
            isFavorite = !isFavorite;
            setFavorite();
        }
        return super.onOptionsItemSelected(item);
    }
}
