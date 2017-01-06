package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by phuong on 5/01/17.
 */
public class ReturnBookOption extends MenuOption {

    public ReturnBookOption(String description) {
        super(description);
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        BookStore bookStore = biblioteca.getBookStore();
        PrintStream printStream = biblioteca.getPrintStream();
        printStream.print("Enter the book you want to return:");
        String title = biblioteca.readUserInput();
        if (!bookStore.returnByTitle(title))
            printStream.println("That is not a valid book to return.");
        else
            printStream.println("Thank you for returning the book.");
    }
}
