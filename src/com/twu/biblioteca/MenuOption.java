package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

/**
 * Created by phuong on 5/01/17.
 */
public class MenuOption {
    private String description;

    public MenuOption(String description) {
        this.description = description;
    }

    public void execute(BookStore bookStore, PrintStream printStream, BufferedReader bufferReader){}

    public String getDescription() {
        return description;
    }
}
