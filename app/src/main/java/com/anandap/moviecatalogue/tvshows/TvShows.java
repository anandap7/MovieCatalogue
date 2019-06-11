package com.anandap.moviecatalogue.tvshows;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShows {
    @SerializedName("results")
    private List<TvShow> results;

    public List<TvShow> getResults() {
        return results;
    }
}
