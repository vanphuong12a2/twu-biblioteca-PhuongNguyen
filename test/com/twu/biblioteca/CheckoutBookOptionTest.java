package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by phuong on 5/01/17.
 */
public class CheckoutBookOptionTest {
    private static final List<MenuOption> EMPTY_MENU = new ArrayList<MenuOption>();
    private BufferedReader bufferReader;
    private PrintStream printStream;
    private BookStore bookStore;
    private CheckoutBookOption checkoutBookOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        biblioteca = new Biblioteca(bookStore, mock(MovieStore.class), mock(UserStore.class), EMPTY_MENU, printStream, bufferReader);
        checkoutBookOption = new CheckoutBookOption("Checkout Book");
    }

    @Test
    public void shouldPrintErrorMessageWhenCheckOutAnUnavailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(false);
        checkoutBookOption.execute(biblioteca);
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldPrintThankYouMessageWhenCheckOutAnAvailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(true);
        checkoutBookOption.execute(biblioteca);
        verify(printStream).println("Thank you! Enjoy the book");
    }
}