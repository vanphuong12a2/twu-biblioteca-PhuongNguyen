package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by phuong on 6/01/17.
 */
public class MovieStoreTest {

    private List<Movie> movies;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movies = new ArrayList<Movie>();
        movie = mock(Movie.class);
        movies.add(movie);
    }

    @Test
    public void shouldListAnEmptyListWhenThereIsNoMovie() throws Exception {
        assertEquals(new MovieStore(EMPTY_LIST).listAllMovies(), EMPTY_LIST);
    }

    @Test
    public void shouldListMoviesWhenThereAre() throws Exception {
        assertEquals(new MovieStore(movies).listAllMovies(), movies);
    }

    @Test
    public void shouldCheckOutWhenAMovieIsAvailable() throws Exception {
        when(movie.getName()).thenReturn("Movie");
        when(movie.isCheckedOut()).thenReturn(false);
        assertTrue(new MovieStore((movies)).checkoutByTitle("Movie"));
        verify(movie).setCheckedOut(true);
    }

    @Test
    public void shouldReturnFalseWhenMovieNameIsUnavailable() throws Exception {
        when(movies.get(0).getName()).thenReturn("Movie1");
        assertFalse(new MovieStore((movies)).checkoutByTitle("Movie"));
    }

    @Test
    public void shouldReturnFalseWhenAllSameNameMoviesAreCheckedOut() throws Exception {
        when(movies.get(0).getName()).thenReturn("Movie");
        when(movie.isCheckedOut()).thenReturn(true);
        assertFalse(new MovieStore((movies)).checkoutByTitle("Movie"));
    }

}