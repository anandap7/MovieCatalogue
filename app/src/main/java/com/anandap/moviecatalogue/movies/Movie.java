package com.anandap.moviecatalogue.movies;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
    private String title, year, overview, director, poster, cast;

    Movie() {
    }

    private Movie(Parcel in) {
        this.title = in.readString();
        this.year = in.readString();
        this.overview = in.readString();
        this.director = in.readString();
        this.poster = in.readString();
        this.cast = in.readString();
    }

    public String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    void setYear(String year) {
        this.year = year;
    }

    public String getOverview() {
        return overview;
    }

    void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDirector() {
        return director;
    }

    void setDirector(String director) {
        this.director = director;
    }

    public String getPoster() {
        return poster;
    }

    void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCast() {
        return cast;
    }

    void setCast(String cast) {
        this.cast = cast;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.year);
        dest.writeString(this.overview);
        dest.writeString(this.director);
        dest.writeString(this.poster);
        dest.writeString(this.cast);
    }
}
