package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by phuong on 5/01/17.
 */
public class CheckoutBookOption extends MenuOption {

    public CheckoutBookOption(String description) {
        super(description);
    }

    @Override
    public boolean requireLogin() {
        return true;
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        BookStore bookStore = biblioteca.getBookStore();
        PrintStream printStream = biblioteca.getPrintStream();
        printStream.print("Enter the book you want to checkout:");
        String title = biblioteca.readUserInput();
        if(!bookStore.checkoutByTitle(title, biblioteca.getCurrentUser()))
            printStream.println("That book is not available.");
        else
            printStream.println("Thank you! Enjoy the book");
    }
}
