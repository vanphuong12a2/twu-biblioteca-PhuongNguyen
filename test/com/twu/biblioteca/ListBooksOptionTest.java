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
 * Created by phuong on 5/01/17.
 */
public class ListBooksOptionTest {
    private static final List<MenuOption> EMPTY_MENU = new ArrayList<MenuOption>();
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
        biblioteca = new Biblioteca(bookStore, mock(MovieStore.class), mock(UserStore.class), EMPTY_MENU, printStream, bufferReader);
        listBooksOption = new ListBooksOption("List books");
    }

    @Test
    public void shouldPrintMessageWhenThereIsNoBook() throws Exception {
        when(bookStore.listAllBooks()).thenReturn(new ArrayList<Book>());
        listBooksOption.execute(biblioteca);
        verify(printStream).println("Sorry, there is no book!");
    }

    @Test
    public void shouldPrintBookDetailsWhenListing() throws Exception {
        Book book = mock(Book.class);
        when(book.getBookDetails()).thenReturn("Book Details");
        when(bookStore.listAllBooks()).thenReturn(Collections.singletonList(book));
        listBooksOption.execute(biblioteca);
        verify(printStream).println("Book Details");
    }

    @Test
    public void shouldNotRequireLogin() throws Exception {
        assertFalse(listBooksOption.requireLogin());
    }
}