package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by phuong on 5/01/17.
 */
public class ListBooksOption extends MenuOption {

    public ListBooksOption(String description) {
        super(description);
    }

    @Override
    public void execute(BookStore bookStore, PrintStream printStream, BufferedReader bufferReader) {
        printStream.println("List of books:");
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "Title", "Authors", "Year", "CheckedOut"));
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "-----", "-------", "----", "----------"));
        List<Book> books = bookStore.listAllBooks();
        for (Book book: books)
            printStream.println(book.getBookDetails());
        printStream.println();
    }
}
