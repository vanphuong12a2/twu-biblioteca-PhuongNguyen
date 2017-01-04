package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by phuong on 4/01/17.
 */
public class Biblioteca {
    public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca!";
    private PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.println(WELCOME_TO_BIBLIOTECA);
    }
}
