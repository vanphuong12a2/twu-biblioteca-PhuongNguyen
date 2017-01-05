package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by phuong on 4/01/17.
 */
public class Biblioteca {
    public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca!";
    private PrintStream printStream;
    private BufferedReader bufferReader;

    public Biblioteca(PrintStream printStream, BufferedReader bufferReader) {
        this.printStream = printStream;
        this.bufferReader = bufferReader;
    }

    public void start() {
        printWelcomeMessage();
        printMainMenu();
        if (readUserInput().equals("0"))
            printStream.println("Select a valid option!");
    }

    private void printWelcomeMessage() {
        printStream.println(WELCOME_TO_BIBLIOTECA);
    }

    private void printMainMenu() {
        printStream.println("List of options:");
        printStream.println("1. List books");
    }

    public String readUserInput() {
        String option = "";
        try {
            option = bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return option;
    }
}
