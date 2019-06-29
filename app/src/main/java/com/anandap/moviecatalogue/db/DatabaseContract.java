package com.anandap.moviecatalogue.db;

public class DatabaseContract {
    static String TABLE_MOVIE = "movies";
    static String TABLE_TV_SHOW = "tvshow";

    static final class MoviesColumns {
        final static String ID = "id";
        final static String TITLE = "title";
        final static String RATING = "rating";
        final static String POSTER = "poster";
        final static String OVERVIEW = "overview";
        final static String RELEASE_DATE = "release_date";
    }

    static final class TVShowColumns {
        final static String ID = "id";
        final static String TITLE = "title";
        final static String RATING = "rating";
        final static String POSTER = "poster";
        final static String OVERVIEW = "overview";
        final static String FIRST_AIR_DATE = "first_air_date";
    }
}
