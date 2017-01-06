package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by phuong on 6/01/17.
 */
public class CheckoutMovieOptionTest {
    private BufferedReader bufferReader;
    private PrintStream printStream;
    private MovieStore movieStore;
    private CheckoutMovieOption checkoutMovieOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        movieStore = mock(MovieStore.class);
        biblioteca = new Biblioteca(mock(BookStore.class), movieStore, EMPTY_LIST, printStream, bufferReader);
        checkoutMovieOption = new CheckoutMovieOption("Checkout Movie");
    }

    @Test
    public void shouldPrintErrorMessageWhenCheckOutAnUnavailableMovie() throws Exception {
        when(bufferReader.readLine()).thenReturn("Titanic").thenReturn("q");
        when(movieStore.checkoutByTitle("Titanic")).thenReturn(false);
        checkoutMovieOption.execute(biblioteca);
        verify(printStream).println("That movie is not available.");
    }

    @Test
    public void shouldPrintThankYouMessageWhenCheckOutAnAvailableMovie() throws Exception {
        when(bufferReader.readLine()).thenReturn("Titanic").thenReturn("q");
        when(movieStore.checkoutByTitle("Titanic")).thenReturn(true);
        checkoutMovieOption.execute(biblioteca);
        verify(printStream).println("Thank you! Enjoy the movie");
    }
}