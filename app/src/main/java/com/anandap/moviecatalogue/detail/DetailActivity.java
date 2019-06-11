package com.anandap.moviecatalogue.detail;

import android.app.ProgressDialog;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV_SHOW = "extra_tv_show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvDate = findViewById(R.id.detail_date);
        TextView tvRatingLabel = findViewById(R.id.label_rating);
        TextView tvRating = findViewById(R.id.detail_rating);
        TextView tvOverview = findViewById(R.id.detail_overview);
        ImageView imgPoster = findViewById(R.id.detail_image);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getResources().getString(R.string.loading));
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (getIntent().getParcelableExtra(EXTRA_MOVIE) != null) {
            tvRatingLabel.setText(getResources().getString(R.string.rating_label));
            Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
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
        } else if (getIntent().getParcelableExtra(EXTRA_TV_SHOW) != null) {
            tvRatingLabel.setText(getResources().getString(R.string.rating_label));
            TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TV_SHOW);
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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
