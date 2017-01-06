package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by phuong on 6/01/17.
 */
public class MovieTest {
    @Test
    public void shouldGetMovieDetailsWithFormat() throws Exception {
        String moviesDetails = new Movie("Titanic", "2003", "Director", 1).getMovieDetails();
        assertEquals(moviesDetails, "Titanic                        2003 Director                       1       ");
    }
}