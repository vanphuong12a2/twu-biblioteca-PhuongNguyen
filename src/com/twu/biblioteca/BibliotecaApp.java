package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new BookStore(), System.out, new BufferedReader(new InputStreamReader(System.in)));
        biblioteca.start();
    }
}
