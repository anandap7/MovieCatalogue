package com.anandap.moviecatalogue.tvshows;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
    private String title, year, overview, poster, creator, cast;

    TvShow() {
    }

    private TvShow(Parcel in) {
        this.title = in.readString();
        this.year = in.readString();
        this.overview = in.readString();
        this.poster = in.readString();
        this.creator = in.readString();
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

    public String getPoster() {
        return poster;
    }

    void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCreator() {
        return creator;
    }

    void setCreator(String creator) {
        this.creator = creator;
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
        dest.writeString(this.poster);
        dest.writeString(this.creator);
        dest.writeString(this.cast);
    }
}
