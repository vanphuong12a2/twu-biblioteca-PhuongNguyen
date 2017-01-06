package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by phuong on 6/01/17.
 */
public class User {

    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String email;
    private final String address;

    public User(String libraryNumber, String password, String name, String email, String address) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Boolean checkNameAndPassword(String libraryNumber, String password) {
        return (libraryNumber.equals(this.libraryNumber) && password.equals(this.password));
    }

    public void displayUserInformation(PrintStream printStream) {
        printStream.println("User information:");
        printStream.println(String.format("%-14s %s", "User name", name));
        printStream.println(String.format("%-14s %s", "Email", email));
        printStream.println(String.format("%-14s %s", "Address", address));
        printStream.println();
    }
}
