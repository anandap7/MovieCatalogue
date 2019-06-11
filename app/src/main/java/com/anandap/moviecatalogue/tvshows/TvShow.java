package com.anandap.moviecatalogue.tvshows;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class TvShow implements Parcelable {
    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String title;
    @SerializedName("vote_average")
    private String rating;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String overview;
    @SerializedName("first_air_date")
    private String first_air_date;

    protected TvShow(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.rating = in.readString();
        this.poster = in.readString();
        this.overview = in.readString();
        this.first_air_date = in.readString();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public String getFirst_air_date() {
        return first_air_date;
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
        dest.writeString(this.first_air_date);
    }
}
