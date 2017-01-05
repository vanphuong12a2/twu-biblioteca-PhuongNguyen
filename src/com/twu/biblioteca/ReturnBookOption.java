package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by phuong on 5/01/17.
 */
public class ReturnBookOption extends MenuOption {

    public ReturnBookOption(String description) {
        super(description);
    }

    @Override
    public void execute(BookStore bookStore, PrintStream printStream, BufferedReader bufferReader) {
        printStream.print("Enter the book you want to return:");
        String title = new InputReader(bufferReader).readUserInput();
        if (!bookStore.returnByTitle(title))
            printStream.println("That is not a valid book to return.");
        else
            printStream.println("Thank you for returning the book.");
    }
}
