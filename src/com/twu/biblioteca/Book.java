package com.twu.biblioteca;

/**
 * Created by phuong on 5/01/17.
 */
public class Book {

    private final String title;
    private final String authors;
    private final String publishedYear;

    public Book(String title, String authors, String publishedYear) {
        this.title = title;
        this.authors = authors;
        this.publishedYear = publishedYear;
    }

    public String getBookDetails() {
        return title + ", " + authors + ", " + publishedYear;
    }
}
