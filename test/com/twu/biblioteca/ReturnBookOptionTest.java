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
 * Created by phuong on 5/01/17.
 */
public class ReturnBookOptionTest {

    private BufferedReader bufferReader;
    private BookStore bookStore;
    private PrintStream printStream;
    private ReturnBookOption returnBookOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        biblioteca = new Biblioteca(bookStore, mock(MovieStore.class), EMPTY_LIST, printStream, bufferReader);
        returnBookOption = new ReturnBookOption("Return Book");
    }

    @Test
    public void shouldPrintErrorMessageWhenReturnAnUnvalidBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.returnByTitle("TDD by Example")).thenReturn(false);
        returnBookOption.execute(biblioteca);
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldPrintThankYouWhenReturnAnValidBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.returnByTitle("TDD by Example")).thenReturn(true);
        returnBookOption.execute(biblioteca);
        verify(printStream).println("Thank you for returning the book.");
    }

}