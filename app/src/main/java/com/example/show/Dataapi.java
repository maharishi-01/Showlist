package com.example.show;

public class Dataapi {

    private String song;
    private String url;
    private String artists;
    private String cover_image;


    public void setSong(String song) {
        this.song = song;
    }

    public String getSong(){return song;}
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getCoverImage() {
        return cover_image;
    }

    public void setCoverImage(String coverImage) {
        this.cover_image = coverImage;
    }

}

