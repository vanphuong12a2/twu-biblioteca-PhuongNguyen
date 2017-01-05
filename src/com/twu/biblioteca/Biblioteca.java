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
            if (input.equals("1"))
                listBooks();
            else if (input.equals("2"))
                checkoutBook();
            else if (input.equals("3"))
                returnBook();
            else
                printStream.println("Select a valid option!");
            printMainMenu();
            input = readUserInput();
        }
        stop();
    }

    private void returnBook() {
        printStream.print("Enter the book you want to return:");
        String title = readUserInput();
        if (!bookStore.returnByTitle(title))
            printStream.println("That is not a valid book to return.");
        else
            printStream.println("Thank you for returning the book.");
    }

    private void checkoutBook() {
        printStream.print("Enter the book you want to checkout:");
        String title = readUserInput();
        if(!bookStore.checkoutByTitle(title))
            printStream.println("That book is not available.");
        else
            printStream.println("Thank you! Enjoy the book");
    }

    private void listBooks() {
        printStream.println("List of books:");
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "Title", "Authors", "Year", "CheckedOut"));
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "-----", "-------", "----", "----------"));
        List<Book> books = bookStore.listAllBooks();
        for (Book book: books)
            printStream.println(book.getBookDetails());
        printStream.println();
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
        printStream.println("2. Checkout book");
        printStream.println("3. Return book");
        printStream.println("q. Quit");
        printStream.print("Please enter the option:");
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
