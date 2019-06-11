package com.anandap.moviecatalogue.movies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anandap.moviecatalogue.R;
import com.anandap.moviecatalogue.detail.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    MovieAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        final Movie movie = getMovies().get(i);
        String sScore = context.getResources().getString(R.string.rating_label) + " : " + movie.getRating();
        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getRelease_date().substring(0, 4));
        holder.tvDirector.setText(sScore);
        Glide.with(context)
                .load(movie.getPoster())
                .apply(new RequestOptions().override(100, 150))
                .into(holder.imgPoster);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvYear, tvDirector;
        ImageView imgPoster;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.movie_title);
            tvYear = itemView.findViewById(R.id.movie_year);
            tvDirector = itemView.findViewById(R.id.movie_rating);
            imgPoster = itemView.findViewById(R.id.movie_image);
            cardView = itemView.findViewById(R.id.movie_cardview);
        }
    }
}
