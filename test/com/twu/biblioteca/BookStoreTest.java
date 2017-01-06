package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

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
    public void shouldReturnTrueAndSetCheckoutedWhenABookIsValid() throws Exception {
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