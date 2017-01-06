package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.mockito.Mockito.*;

/**
 * Created by phuong on 6/01/17.
 */
public class ListMoviesOptionTest {
    private static final List<MenuOption> EMPTY_MENU = new ArrayList<MenuOption>();
    private BufferedReader bufferReader;
    private PrintStream printStream;
    private MovieStore movieStore;
    private ListMoviesOption listMoviesOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        movieStore = mock(MovieStore.class);
        biblioteca = new Biblioteca(mock(BookStore.class), movieStore, mock(UserStore.class), EMPTY_MENU, printStream, bufferReader);
        listMoviesOption = new ListMoviesOption("List movies");
    }

    @Test
    public void shouldPrintMessageWhenThereIsNoMovie() throws Exception {
        when(movieStore.listAllMovies()).thenReturn(new ArrayList<Movie>());
        listMoviesOption.execute(biblioteca);
        verify(printStream).println("Sorry, there is no movie!");
    }

    @Test
    public void shouldPrintMovieDetailsWhenListing() throws Exception {
        Movie movie = mock(Movie.class);
        when(movie.getMovieDetails()).thenReturn("Movie Details");
        when(movieStore.listAllMovies()).thenReturn(Collections.singletonList(movie));
        listMoviesOption.execute(biblioteca);
        verify(printStream).println("Movie Details");
    }

    @Test
    public void shouldNotRequireLogin() throws Exception {
        assertFalse(listMoviesOption.requireLogin());
    }
}