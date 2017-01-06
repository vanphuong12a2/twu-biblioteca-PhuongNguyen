package com.twu.biblioteca;

/**
 * Created by phuong on 6/01/17.
 */
public class User {

    private final String libraryNumber;
    private final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public Boolean checkNameAndPassword(String libraryNumber, String password) {
        return (libraryNumber.equals(this.libraryNumber) && password.equals(this.password));
    }
}
