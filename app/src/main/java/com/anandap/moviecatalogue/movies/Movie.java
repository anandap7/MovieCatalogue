package com.anandap.moviecatalogue.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

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
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String overview;
    @SerializedName("release_date")
    private String release_date;

    protected Movie(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.rating = in.readString();
        this.poster = in.readString();
        this.overview = in.readString();
        this.release_date = in.readString();
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public String getPoster() {
        return "https://image.tmdb.org/t/p/w300_and_h450_bestv2" + poster;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.rating);
        dest.writeString(this.poster);
        dest.writeString(this.overview);
        dest.writeString(this.release_date);
    }
}
