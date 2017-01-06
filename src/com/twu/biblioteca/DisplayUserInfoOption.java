package com.twu.biblioteca;

/**
 * Created by phuong on 6/01/17.
 */
public class DisplayUserInfoOption extends MenuOption{
    public DisplayUserInfoOption(String description) {
        super(description);
    }

    @Override
    public boolean requireLogin() {
        return true;
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        biblioteca.getCurrentUser().displayUserInformation(biblioteca.getPrintStream());
    }
}
