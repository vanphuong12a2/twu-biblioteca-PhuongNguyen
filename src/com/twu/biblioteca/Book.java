package com.twu.biblioteca;

/**
 * Created by phuong on 5/01/17.
 */
public class Book {

    private final String title;
    private final String authors;
    private final String publishedYear;
    private boolean checkedOut;

    public Book(String title, String authors, String publishedYear, Boolean checkedOut) {
        this.title = title;
        this.authors = authors;
        this.publishedYear = publishedYear;
        this.checkedOut = checkedOut;
    }

    public Book(String title, String authors, String publishedYear) {
        this(title, authors, publishedYear, false);
    }

    public String getBookDetails() {
        return String.format("%-40s %-26s %-4s", title, authors, publishedYear);
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
