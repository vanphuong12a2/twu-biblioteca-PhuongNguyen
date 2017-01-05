package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = getBooks();
        List<MenuOption> menuOptions = getStringMenuOptionHashMap();
        Biblioteca biblioteca = new Biblioteca(new BookStore(books), menuOptions, System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.start();
    }

    private static List<MenuOption> getStringMenuOptionHashMap() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListBooksOption("List books"));
        menuOptions.add(new CheckoutBookOption("Checkout book"));
        menuOptions.add(new ReturnBookOption("Return book"));
        return menuOptions;
    }

    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bert Bates and Kathy Sierra", "2003"));
        books.add(new Book("TDD by Example", "Kent Beck", "2003", true));
        return books;
    }
}
