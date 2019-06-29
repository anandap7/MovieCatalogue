package com.anandap.moviecatalogue.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anandap.moviecatalogue.movies.Movie;

import java.util.ArrayList;

import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.ID;
import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.OVERVIEW;
import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.POSTER;
import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.RATING;
import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.RELEASE_DATE;
import static com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns.TITLE;
import static com.anandap.moviecatalogue.db.DatabaseContract.TABLE_MOVIE;

public class MovieHelper {
    private static final String DATABASE_TABLE = TABLE_MOVIE;
    private static DatabaseHelper dataBaseHelper;
    private static MovieHelper INSTANCE;
    private static SQLiteDatabase database;

    private MovieHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static MovieHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new MovieHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    private void open() throws SQLException {
        database = dataBaseHelper.getWritableDatabase();
    }

    private void close() {
        dataBaseHelper.close();
        if (database.isOpen())
            database.close();
    }

    public ArrayList<Movie> getAllMovies() {
        INSTANCE.open();
        ArrayList<Movie> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                ID + " ASC",
                null);
        cursor.moveToFirst();
        Movie movie;
        if (cursor.getCount() > 0) {
            do {
                movie = new Movie();
                movie.setId(cursor.getString(cursor.getColumnIndexOrThrow(ID)));
                movie.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                movie.setRating(cursor.getString(cursor.getColumnIndexOrThrow(RATING)));
                movie.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                movie.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(OVERVIEW)));
                movie.setRelease_date(cursor.getString(cursor.getColumnIndexOrThrow(RELEASE_DATE)));
                arrayList.add(movie);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        INSTANCE.close();
        return arrayList;
    }

    public long insertMovie(Movie movie) {
        INSTANCE.open();
        ContentValues args = new ContentValues();
        args.put(ID, movie.getId());
        args.put(TITLE, movie.getTitle());
        args.put(RATING, movie.getRating());
        args.put(POSTER, movie.getPosterName());
        args.put(OVERVIEW, movie.getOverview());
        args.put(RELEASE_DATE, movie.getRelease_date());
        long result = database.insert(DATABASE_TABLE, null, args);
        INSTANCE.close();
        return result;
    }

    public int findMovie(String id) {
        INSTANCE.open();
        Cursor cursor = database.query(TABLE_MOVIE, null, "id='" + id + "'", null, null, null, null);
        int result = cursor.getCount();
        cursor.close();
        INSTANCE.close();
        return result;
    }

    public int deleteMovie(String id) {
        INSTANCE.open();
        int result = database.delete(TABLE_MOVIE, ID + " = '" + id + "'", null);
        INSTANCE.close();
        return result;
    }
}
