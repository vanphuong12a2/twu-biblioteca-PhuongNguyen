package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by phuong on 5/01/17.
 */
public class CheckoutBookOptionTest {
    private BufferedReader bufferReader;
    private PrintStream printStream;
    private BookStore bookStore;
    private CheckoutBookOption checkoutBookOption;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        checkoutBookOption = new CheckoutBookOption("Checkout Book");
    }

    @Test
    public void shouldPrintErrorMessageWhenCheckOutAnUnavailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(false);
        checkoutBookOption.execute(bookStore, printStream, bufferReader);
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldPrintThankYouMessageWhenCheckOutAnAvailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(true);
        checkoutBookOption.execute(bookStore, printStream, bufferReader);
        verify(printStream).println("Thank you! Enjoy the book");
    }

}