package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by phuong on 5/01/17.
 */
public class BookStoreTest {
    @Test
    public void shouldListAnEmptyListWhenThereIsNoBook() throws Exception {
        assertEquals(new BookStore(EMPTY_LIST).listAllBooks(), EMPTY_LIST);
    }

    @Test
    public void shouldListBooksWhenThereAre() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(mock(Book.class));
        assertEquals(new BookStore(books).listAllBooks(), books);
    }
}