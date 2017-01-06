package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = getBooks();
        List<MenuOption> menuOptions = getStringMenuOptionHashMap();
        List<Movie> movies = getMovies();
        Biblioteca biblioteca = new Biblioteca(new BookStore(books), new MovieStore(movies), menuOptions, System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.start();
    }

    private static List<MenuOption> getStringMenuOptionHashMap() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListBooksOption("List books"));
        menuOptions.add(new CheckoutBookOption("Checkout book"));
        menuOptions.add(new ReturnBookOption("Return book"));
        menuOptions.add(new ListMoviesOption("List movies"));
        menuOptions.add(new CheckoutMovieOption("Checkout movie"));
        return menuOptions;
    }

    private static List<Book> getBooks() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bert Bates and Kathy Sierra", "2003"));
        books.add(new Book("TDD by Example", "Kent Beck", "2003", true));
        return books;
    }

    public static List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Titanic", "2017", "Director?", 10));
        return movies;
    }
}
