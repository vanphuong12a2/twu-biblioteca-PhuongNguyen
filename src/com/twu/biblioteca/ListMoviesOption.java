package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by phuong on 6/01/17.
 */
public class ListMoviesOption extends MenuOption{
    public ListMoviesOption(String description) {
        super(description);
    }

    @Override
    public void execute(Biblioteca biblioteca) {
        PrintStream printStream = biblioteca.getPrintStream();
        MovieStore movieStore = biblioteca.getMovieStore();
        printStream.println(String.format("%-30s %-4s %-30s %-6s %-1s", "name", "year", "director", "rating", "checkedOut"));
        printStream.println(String.format("%-30s %-4s %-30s %-6s %-1s", "----", "----", "--------", "------", "----------"));
        printStream.println("List of movies:");
        List<Movie> movies = movieStore.listAllMovies();
        if (movies.isEmpty())
            printStream.println("Sorry, there is no movie!");
        else {
            for (Movie movie : movies)
                printStream.println(movie.getMovieDetails());
            printStream.println();
        }
    }
}
