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
    private User user;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        book = mock(Book.class);
        books.add(book);
        user = mock(User.class);
    }

    @Test
    public void shouldReturnTrueAndSetUserWhenCheckoutValidBook() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(false);
        assertTrue(new BookStore((books)).checkoutByTitle("Title", user));
        verify(book).setUser(user);
    }

    @Test
    public void shouldReturnFalseWhenCheckoutInvalidBook() throws Exception {
        when(book.getTitle()).thenReturn("Title1");
        assertFalse(new BookStore((books)).checkoutByTitle("Title", user));
    }

    @Test
    public void shouldReturnFalseWhenCheckoutUnAvailableBook() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(true);
        assertFalse(new BookStore((books)).checkoutByTitle("Title", user));
    }

    @Test
    public void shouldReturnTrueAndSetUserToNullWhenReturnValidBook() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(true);
        assertTrue(new BookStore((books)).returnByTitle("Title"));
        verify(book).setUser(null);
    }

    @Test
    public void shouldReturnFalseWhenReturnInvalidBook() throws Exception {
        when(book.getTitle()).thenReturn("Title1");
        assertFalse(new BookStore((books)).returnByTitle("Title"));
    }

    @Test
    public void shouldReturnFalseWhenReturnUnavailableBook() throws Exception {
        when(book.getTitle()).thenReturn("Title");
        when(book.isCheckedOut()).thenReturn(false);
        assertFalse(new BookStore((books)).returnByTitle("Title"));
    }
}