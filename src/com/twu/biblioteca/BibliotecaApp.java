package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<MenuOption> menuOptions = getStringMenuOptionHashMap();
        BookStore bookStore = getBookStore();
        MovieStore movieStore = getMovieStore();
        UserStore userStore = getUserStore();
        Biblioteca biblioteca = new Biblioteca(bookStore, movieStore, userStore, menuOptions, System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.start();
    }

    private static List<MenuOption> getStringMenuOptionHashMap() {
        List<MenuOption> menuOptions = new ArrayList<MenuOption>();
        menuOptions.add(new ListBooksOption("List books"));
        menuOptions.add(new CheckoutBookOption("Checkout book"));
        menuOptions.add(new ReturnBookOption("Return book"));
        menuOptions.add(new ListMoviesOption("List movies"));
        menuOptions.add(new CheckoutMovieOption("Checkout movie"));
        menuOptions.add(new LoginOption("Login"));
        menuOptions.add(new DisplayUserInfoOption("User Information"));
        return menuOptions;
    }

    public static BookStore getBookStore() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Bert Bates and Kathy Sierra", "2003"));
        books.add(new Book("TDD by Example", "Kent Beck", "2003", true, null));
        return new BookStore(books);
    }

    public static MovieStore getMovieStore() {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Titanic", "2017", "Director?", 10));
        return new MovieStore(movies);
    }

    public static UserStore getUserStore() {
        List<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "123456", "Ally Miles", "ally@gmail.com", "Barcelona, Spain"));
        return new UserStore(users);
    }
}
