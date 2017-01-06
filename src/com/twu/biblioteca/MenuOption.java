package com.twu.biblioteca;

/**
 * Created by phuong on 5/01/17.
 */
public class MenuOption {
    private String description;

    public MenuOption(String description) {
        this.description = description;
    }

    public void execute(Biblioteca biblioteca){}

    public String getDescription() {
        return description;
    }

    public boolean requireLogin() {
        return false;
    }
}
