package com.twu.biblioteca;

/**
 * Created by phuong on 5/01/17.
 */
public class Book {

    private final String title;
    private final String authors;
    private final String publishedYear;
    private boolean checkedOut;
    private User user;

    public Book(String title, String authors, String publishedYear, Boolean checkedOut, User user) {
        this.title = title;
        this.authors = authors;
        this.publishedYear = publishedYear;
        this.checkedOut = checkedOut;
        this.user = user;
    }

    public Book(String title, String authors, String publishedYear) {
        this(title, authors, publishedYear, false, null);
    }

    public String getBookDetails() {
        return String.format("%-30s %-30s %-4s %-1s", title, authors, publishedYear, checkedOut?"x":"");
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

    public void setUser(User user) {
        this.user = user;
    }
}
