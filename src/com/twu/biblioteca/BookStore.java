package com.twu.biblioteca;

import java.util.List;

/**
 * Created by phuong on 5/01/17.
 */
public class BookStore {
    private final List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

    public List<Book> listAllBooks() {
        return books;
    }

    public boolean checkAvailableByTitle(String title) {
        return false;
    }

    public void checkoutByTitle(String s) {

    }
}
