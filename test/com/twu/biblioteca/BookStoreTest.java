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
 * Created by phuong on 5/01/17.
 */
public class BookStoreTest {

    private List<Book> books;
    private Book book;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        book = mock(Book.class);
        books.add(book);

    }

    @Test
    public void shouldListAnEmptyListWhenThereIsNoBook() throws Exception {
        assertEquals(new BookStore(EMPTY_LIST).listAllBooks(), EMPTY_LIST);
    }

    @Test
    public void shouldListBooksWhenThereAre() throws Exception {
        assertEquals(new BookStore(books).listAllBooks(), books);
    }

    @Test
    public void shouldCheckOutWhenABookIsAvailable() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(false);
        assertTrue(new BookStore((books)).checkoutByTitle("Title"));
        verify(book).setCheckedOut(true);
    }

    @Test
    public void shouldReturnFalseWhenBookNameIsUnavailable() throws Exception {
        when(books.get(0).getTitle()).thenReturn("Title1");
        assertFalse(new BookStore((books)).checkoutByTitle("Title"));
    }

    @Test
    public void shouldReturnFalseWhenAllSameNameBooksAreCheckedOut() throws Exception {
        when(books.get(0).getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(true);
        assertFalse(new BookStore((books)).checkoutByTitle("Title"));
    }

    @Test
    public void shouldReturnWhenABookIsValid() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(true);
        assertTrue(new BookStore((books)).returnByTitle("Title"));
        verify(book).setCheckedOut(false);
    }

    @Test
    public void shouldReturnFalseWhenABookIsInvalid() throws Exception {
        when(books.get(0).getTitle()).thenReturn("Title1");
        assertFalse(new BookStore((books)).returnByTitle("Title"));
    }

    @Test
    public void shouldReturnFalseWhenAllSameNameBooksAreNotCheckedOut() throws Exception {
        when(books.get(0).getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(false);
        assertFalse(new BookStore((books)).returnByTitle("Title"));
    }
}