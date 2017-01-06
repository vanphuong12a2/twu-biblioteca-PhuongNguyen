package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by phuong on 6/01/17.
 */
public class LoginOption extends MenuOption{
    public LoginOption(String description) {
        super(description);
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        PrintStream printStream = biblioteca.getPrintStream();
        String libraryNumber = getLibraryName(biblioteca, printStream);
        String password = getPassword(biblioteca, printStream);
        User currentUser = biblioteca.getUserStore().getUserByNameAndCheckPassword(libraryNumber, password);
        if(currentUser != null) {
            biblioteca.setCurrentUser(currentUser);
            printStream.println("You have logged in!");
        } else {
            printStream.println("Wrong library number or password!");
        }
    }

    private String getPassword(Biblioteca biblioteca, PrintStream printStream) {
        printStream.print("Enter your password:");
        return biblioteca.readUserInput();
    }

    private String getLibraryName(Biblioteca biblioteca, PrintStream printStream) {
        printStream.print("Enter your library number:");
        return biblioteca.readUserInput();
    }
}
