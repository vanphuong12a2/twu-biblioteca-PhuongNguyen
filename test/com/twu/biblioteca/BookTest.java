package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by phuong on 5/01/17.
 */
public class BookTest {
    @Test
    public void shouldGetBookDetailsWithFormat() throws Exception {
        String bookDetails = new Book("Head First Java", "Bert Bates and Kathy Sierra", "2003").getBookDetails();
        assertEquals(bookDetails, "Head First Java                          Bert Bates and Kathy Sierra 2003");
    }
}