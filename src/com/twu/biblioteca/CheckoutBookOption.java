package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by phuong on 5/01/17.
 */
public class CheckoutBookOption extends MenuOption {

    public CheckoutBookOption(String description) {
        super(description);
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        BookStore bookStore = biblioteca.getBookStore();
        PrintStream printStream = biblioteca.getPrintStream();
        BufferedReader bufferReader = biblioteca.getBufferReader();
        printStream.print("Enter the book you want to checkout:");
        String title = new InputReader(bufferReader).readUserInput();
        if(!bookStore.checkoutByTitle(title))
            printStream.println("That book is not available.");
        else
            printStream.println("Thank you! Enjoy the book");
    }
}
