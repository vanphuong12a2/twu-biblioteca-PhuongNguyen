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

    public boolean checkoutByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title) && !book.isCheckedOut()) {
                book.setCheckedOut(true);
                return true;
            }
        }
        return false;
    }

    public boolean returnByTitle(String title) {
        for (Book book: books) {
            if (book.getTitle().equals(title) && book.isCheckedOut()) {
                book.setCheckedOut(false);
                return true;
            }
        }
        return false;
    }
}
