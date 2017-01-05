package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<Book>();
        Biblioteca biblioteca = new Biblioteca(new BookStore(books), System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.start();
    }
}
