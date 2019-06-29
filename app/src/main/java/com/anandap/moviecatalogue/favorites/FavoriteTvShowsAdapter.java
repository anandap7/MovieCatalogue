package com.anandap.moviecatalogue.favorites;

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
import com.anandap.moviecatalogue.tvshows.TvShow;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FavoriteTvShowsAdapter extends RecyclerView.Adapter<FavoriteTvShowsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TvShow> tvShows = new ArrayList<>();

    public FavoriteTvShowsAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<TvShow> getTvShows() {
        return tvShows;
    }

    public void setTvShows(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.tv_show_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        final TvShow tvShow = getTvShows().get(i);
        holder.tvTitle.setText(tvShow.getTitle());
        Glide.with(context)
                .load(tvShow.getPoster())
                .into(holder.imgPoster);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_TV_SHOW, tvShow);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgPoster;
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_show_title);
            imgPoster = itemView.findViewById(R.id.tv_show_image);
            cardView = itemView.findViewById(R.id.tv_show_cardview);
        }
    }
}
