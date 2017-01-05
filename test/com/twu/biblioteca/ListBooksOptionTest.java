package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;

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

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        listBooksOption = new ListBooksOption("List books");
    }

    @Test
    public void shouldPrintBookDetailsWhenListing() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        Book book = mock(Book.class);
        when(book.getBookDetails()).thenReturn("Book Details");
        when(bookStore.listAllBooks()).thenReturn(Arrays.asList(book));
        listBooksOption.execute(bookStore, printStream, bufferReader);
        verify(printStream).println("Book Details");
    }
}