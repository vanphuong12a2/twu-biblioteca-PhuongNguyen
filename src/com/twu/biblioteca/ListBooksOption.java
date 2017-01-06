package com.twu.biblioteca;

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
    public void execute(Biblioteca biblioteca) {
        BookStore bookStore = biblioteca.getBookStore();
        PrintStream printStream =  biblioteca.getPrintStream();
        printStream.println("List of books:");
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "Title", "Authors", "Year", "CheckedOut"));
        printStream.println(String.format("%-30s %-30s %-4s %-9s", "-----", "-------", "----", "----------"));
        List<Book> books = bookStore.listAllBooks();
        if (books.isEmpty())
            printStream.println("Sorry, there is no book!");
        else {
            for (Book book : books)
                printStream.println(book.getBookDetails());
            printStream.println();
        }
    }
}
