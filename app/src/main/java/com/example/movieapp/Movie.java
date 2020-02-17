package com.example.movieapp;

public class Movie {

    private String title;
    private double imdbratings;
    private String imdbId;
    private String production;
    private String Runtime;
    private int thumnail;

    public Movie(String title, int thumnail) {
        this.title = title;
        this.thumnail = thumnail;
    }

    public Movie(String title, double imdbratings, String imdbId, String production, String runtime, int thumnail) {
        this.title = title;
        this.imdbratings = imdbratings;
        this.imdbId = imdbId;
        this.production = production;
        Runtime = runtime;
        this.thumnail = thumnail;


    }

    public String getTitle() {
        return title;
    }

    public double getImdbratings() {
        return imdbratings;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getProduction() {
        return production;
    }

    public String getRuntime() {
        return Runtime;
    }

    public int getThumnail() {
        return thumnail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImdbratings(double imdbratings) {
        this.imdbratings = imdbratings;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public void setThumnail(int thumnail) {
        this.thumnail = thumnail;
    }
}
