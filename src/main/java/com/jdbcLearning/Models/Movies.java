package com.jdbcLearning.Models;

public class Movies {

    private int movieId;
    private String movieTitle;
    private String movieGenre;
    private String releaseDate;


    public Movies(){

    }

    public Movies(String movieTitle, String movieGenre, String releaseDate) {
        this.movieGenre = movieGenre;
        this.movieTitle = movieTitle;
        this.releaseDate = releaseDate;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieGenre='" + movieGenre + '\'' +
                ", movieId=" + movieId +
                ", movieTitle='" + movieTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
