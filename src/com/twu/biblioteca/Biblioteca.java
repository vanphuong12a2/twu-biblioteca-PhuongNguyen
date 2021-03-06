package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by phuong on 4/01/17.
 */
public class Biblioteca {
    public static final String WELCOME_TO_BIBLIOTECA = "Welcome to Biblioteca!";
    private MovieStore movieStore;
    private UserStore userStore;
    private PrintStream printStream;
    private BookStore bookStore;
    private List<MenuOption> menuOptions;
    private InputReader inputReader;
    private User currentUser = null;

    public Biblioteca(BookStore bookStore, MovieStore movieStore, UserStore userStore, List<MenuOption> menuOptions, PrintStream printStream, BufferedReader bufferReader) {
        this.printStream = printStream;
        this.bookStore = bookStore;
        this.movieStore = movieStore;
        this.userStore = userStore;
        this.menuOptions = menuOptions;
        this.inputReader = new InputReader(bufferReader);
    }

    public void start() {
        printWelcomeMessage();
        printMainMenu();
        String input = readUserInput();
        while (!input.equals("q")) {
            Integer optionPosition = Integer.parseInt(input) - 1;
            if (optionPosition >= 0 && optionPosition < menuOptions.size()) {
                MenuOption menuOption = menuOptions.get(optionPosition);
                if (menuOption.requireLogin() && currentUser == null)
                    printStream.println("Please login to perform this action!");
                else
                    menuOptions.get(optionPosition).execute(this);
            }
            else
                printStream.println("Select a valid option!");
            printMainMenu();
            input = readUserInput();
        }
        stop();
    }

    private void stop() {
        printStream.println("Good bye!");
    }

    private void printWelcomeMessage() {
        printStream.println(WELCOME_TO_BIBLIOTECA);
    }

    private void printMainMenu() {
        printStream.println("List of options:");
        for(int i = 0; i < menuOptions.size(); i++) {
            printStream.println((i + 1) + ". " + menuOptions.get(i).getDescription());
        }
        printStream.println("q. Quit");
        printStream.print("Please enter the option:");
    }

    public String readUserInput() { return inputReader.readUserInput(); }

    public BookStore getBookStore() {
        return bookStore;
    }

    public MovieStore getMovieStore() {
        return movieStore;
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public UserStore getUserStore() {
        return userStore;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() { return currentUser; }
}
