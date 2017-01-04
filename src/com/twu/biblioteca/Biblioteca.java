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
        printWelcomeMessage();
        printMainMenu();
    }

    private void printWelcomeMessage() {
        printStream.println(WELCOME_TO_BIBLIOTECA);
    }

    private void printMainMenu() {
        printStream.println("List of options:");
        printStream.println("1. List books");
    }
}
