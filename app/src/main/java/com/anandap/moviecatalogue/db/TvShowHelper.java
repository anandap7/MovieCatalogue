package com.anandap.moviecatalogue.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.anandap.moviecatalogue.tvshows.TvShow;

import java.util.ArrayList;

import static com.anandap.moviecatalogue.db.DatabaseContract.TABLE_TV_SHOW;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.FIRST_AIR_DATE;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.ID;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.OVERVIEW;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.POSTER;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.RATING;
import static com.anandap.moviecatalogue.db.DatabaseContract.TVShowColumns.TITLE;

public class TvShowHelper {

    private static final String DATABASE_TABLE = TABLE_TV_SHOW;
    private static DatabaseHelper dataBaseHelper;
    private static TvShowHelper INSTANCE;
    private static SQLiteDatabase database;

    private TvShowHelper(Context context) {
        dataBaseHelper = new DatabaseHelper(context);
    }

    public static TvShowHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TvShowHelper(context);
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

    public ArrayList<TvShow> getAllTvShows() {
        INSTANCE.open();
        ArrayList<TvShow> arrayList = new ArrayList<>();
        Cursor cursor = database.query(DATABASE_TABLE, null,
                null,
                null,
                null,
                null,
                ID + " ASC",
                null);
        cursor.moveToFirst();
        TvShow tvShow;
        if (cursor.getCount() > 0) {
            do {
                tvShow = new TvShow();
                tvShow.setId(cursor.getString(cursor.getColumnIndexOrThrow(ID)));
                tvShow.setTitle(cursor.getString(cursor.getColumnIndexOrThrow(TITLE)));
                tvShow.setRating(cursor.getString(cursor.getColumnIndexOrThrow(RATING)));
                tvShow.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(POSTER)));
                tvShow.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(OVERVIEW)));
                tvShow.setFirst_air_date(cursor.getString(cursor.getColumnIndexOrThrow(FIRST_AIR_DATE)));
                arrayList.add(tvShow);
                cursor.moveToNext();
            } while (!cursor.isAfterLast());
        }
        cursor.close();
        INSTANCE.close();
        return arrayList;
    }

    public long insertTvShow(TvShow tvShow) {
        INSTANCE.open();
        ContentValues args = new ContentValues();
        args.put(ID, tvShow.getId());
        args.put(TITLE, tvShow.getTitle());
        args.put(RATING, tvShow.getRating());
        args.put(POSTER, tvShow.getPosterName());
        args.put(OVERVIEW, tvShow.getOverview());
        args.put(FIRST_AIR_DATE, tvShow.getFirst_air_date());
        long result = database.insert(DATABASE_TABLE, null, args);
        INSTANCE.close();
        return result;
    }

    public int findTvShow(String id) {
        INSTANCE.open();
        Cursor cursor = database.query(TABLE_TV_SHOW, null, "id='" + id + "'", null, null, null, null);
        int result = cursor.getCount();
        cursor.close();
        INSTANCE.close();
        return result;
    }

    public int deleteTvShow(String id) {
        INSTANCE.open();
        int result = database.delete(TABLE_TV_SHOW, ID + " = '" + id + "'", null);
        INSTANCE.close();
        return result;
    }
}
