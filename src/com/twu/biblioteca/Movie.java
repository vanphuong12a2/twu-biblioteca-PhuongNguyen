package com.twu.biblioteca;

/**
 * Created by phuong on 6/01/17.
 */
public class Movie {
    private final String name;
    private final String year;
    private final String director;
    private int rating;
    private Boolean checkedOut;

    public Movie(String name, String year, String director, int rating) {
        this(name, year, director, rating, false);
    }

    public Movie(String name, String year, String director, int rating, Boolean checkedOut) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.checkedOut = checkedOut;
    }

    public String getMovieDetails() {
        return String.format("%-30s %-4s %-30s %-6s %-1s", name, year, director, rating, checkedOut?"x":"");
    }
}
