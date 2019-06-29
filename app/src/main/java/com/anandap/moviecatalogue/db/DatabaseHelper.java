package com.anandap.moviecatalogue.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anandap.moviecatalogue.db.DatabaseContract.MoviesColumns;
import com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_MOVIE = String.format("CREATE TABLE %s"
                    + " (%s TEXT PRIMARY KEY," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_MOVIE,
            MoviesColumns.ID,
            MoviesColumns.TITLE,
            MoviesColumns.RATING,
            MoviesColumns.POSTER,
            MoviesColumns.OVERVIEW,
            MoviesColumns.RELEASE_DATE
    );
    private static final String CREATE_TABLE_TV_SHOW = String.format("CREATE TABLE %s"
                    + " (%s TEXT PRIMARY KEY," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL," +
                    " %s TEXT NOT NULL)",
            DatabaseContract.TABLE_TV_SHOW,
            TVShowColumns.ID,
            TVShowColumns.TITLE,
            TVShowColumns.RATING,
            TVShowColumns.POSTER,
            TVShowColumns.OVERVIEW,
            TVShowColumns.FIRST_AIR_DATE
    );
    public static String DATABASE_NAME = "dbmoviecatalogue";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MOVIE);
        db.execSQL(CREATE_TABLE_TV_SHOW);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_MOVIE);
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_TV_SHOW);
        onCreate(db);
    }
}
