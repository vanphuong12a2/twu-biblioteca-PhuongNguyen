package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by phuong on 6/01/17.
 */
public class CheckoutMovieOption extends MenuOption {
    public CheckoutMovieOption(String description) {
        super(description);
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        MovieStore movieStore = biblioteca.getMovieStore();
        PrintStream printStream = biblioteca.getPrintStream();
        BufferedReader bufferReader = biblioteca.getBufferReader();
        printStream.print("Enter the movie you want to checkout:");
        String title = new InputReader(bufferReader).readUserInput();
        if(!movieStore.checkoutByTitle(title))
            printStream.println("That movie is not available.");
        else
            printStream.println("Thank you! Enjoy the movie");
    }
}
