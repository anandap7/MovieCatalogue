package com.anandap.moviecatalogue.api;

import com.anandap.moviecatalogue.movies.Movies;
import com.anandap.moviecatalogue.tvshows.TvShows;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //key 189e40dd8f626cd7f35fed458fe7c0ef

    @GET("/3/discover/movie")
    Call<Movies> getMovies(@Query("api_key") String api_key);

    @GET("/3/discover/tv")
    Call<TvShows> getTvShows(@Query("api_key") String api_key);
}
