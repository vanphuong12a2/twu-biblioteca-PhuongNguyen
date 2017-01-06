package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;

import static java.util.Collections.EMPTY_LIST;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by phuong on 5/01/17.
 */
public class ListBooksOptionTest {
    private BufferedReader bufferReader;
    private PrintStream printStream;
    private BookStore bookStore;
    private ListBooksOption listBooksOption;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        biblioteca = new Biblioteca(bookStore, mock(MovieStore.class), EMPTY_LIST, printStream, bufferReader);
        listBooksOption = new ListBooksOption("List books");
    }

    @Test
    public void shouldPrintMessageWhenThereIsNoBook() throws Exception {
        when(bookStore.listAllBooks()).thenReturn(EMPTY_LIST);
        listBooksOption.execute(biblioteca);
        verify(printStream).println("Sorry, there is no book!");
    }

    @Test
    public void shouldPrintBookDetailsWhenListing() throws Exception {
        Book book = mock(Book.class);
        when(book.getBookDetails()).thenReturn("Book Details");
        when(bookStore.listAllBooks()).thenReturn(Arrays.asList(book));
        listBooksOption.execute(biblioteca);
        verify(printStream).println("Book Details");
    }
}