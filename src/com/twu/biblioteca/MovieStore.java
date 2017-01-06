package com.twu.biblioteca;

import java.util.List;

/**
 * Created by phuong on 6/01/17.
 */
public class MovieStore {

    private List<Movie> movies;

    public MovieStore(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> listAllMovies() {
        return movies;
    }
}
