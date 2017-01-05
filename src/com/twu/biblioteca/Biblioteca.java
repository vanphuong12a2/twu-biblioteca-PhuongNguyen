package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by phuong on 4/01/17.
 */
public class Biblioteca {
    public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca!";
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private BookStore bookStore;

    public Biblioteca(BookStore bookStore, PrintStream printStream, BufferedReader bufferReader) {
        this.printStream = printStream;
        this.bufferReader = bufferReader;
        this.bookStore = bookStore;
    }

    public void start() {
        printWelcomeMessage();
        printMainMenu();
        String input = readUserInput();
        while (!input.equals("q")) {
            if (!input.equals("1"))
                printStream.println("Select a valid option!");
            else listBooks();
            printMainMenu();
            input = readUserInput();
        }
        stop();
    }

    private void listBooks() {
        printStream.println("List of books:");
        List<Book> books = bookStore.listAllBooks();
        printStream.println(books);
    }

    private void stop() {
        printStream.println("Good bye!");
    }

    private void printWelcomeMessage() {
        printStream.println(WELCOME_TO_BIBLIOTECA);
    }

    private void printMainMenu() {
        printStream.println("List of options:");
        printStream.println("1. List books");
        printStream.println("q. Quit");
        printStream.println("Please enter the option:");
    }

    public String readUserInput() {
        String option = null;
        try {
            option = bufferReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return option;
    }
}
