package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by phuong on 4/01/17.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BufferedReader bufferReader;
    private BookStore bookStore;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        bookStore = mock(BookStore.class);
        when(bufferReader.readLine()).thenReturn("q");
        biblioteca = new Biblioteca(bookStore, printStream, bufferReader);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting() throws Exception {
        biblioteca.start();
        verify(printStream).println(Biblioteca.WELCOME_TO_BIBLIOTECA);
    }

    @Test
    public void shouldPrintMainMenuWhenStarting() throws Exception {
        biblioteca.start();
        verify(printStream).println("List of options:");
        verify(printStream).println("1. List books");
        verify(printStream).println("2. Checkout book");
        verify(printStream).println("3. Return book");
        verify(printStream).println("q. Quit");
        verify(printStream).print("Please enter the option:");
    }

    @Test
    public void shouldBeAbleToReadUserInput1() throws Exception {
        when(bufferReader.readLine()).thenReturn("1");
        assertEquals(biblioteca.readUserInput(), "1");
    }

    @Test
    public void shouldBeAbleToReadUserInput2() throws Exception {
        when(bufferReader.readLine()).thenReturn("2");
        assertEquals(biblioteca.readUserInput(), "2");
    }

    @Test
    public void shouldPrintErrorMessageWhenUserChoosesAnInvalidOption() throws Exception {
        when(bufferReader.readLine()).thenReturn("0").thenReturn("q");
        biblioteca.start();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldPrintErrorMessageWhenUserChoosesAnotherInvalidOption() throws Exception {
        when(bufferReader.readLine()).thenReturn("-1").thenReturn("q");
        biblioteca.start();
        verify(printStream).println("Select a valid option!");
    }

    @Test
    public void shouldAllowReEnterWhenUserChoosesAnInvalidOption() throws Exception {
        when(bufferReader.readLine()).thenReturn("0").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(2)).print("Please enter the option:");
    }


    @Test
    public void shouldAllowReEnterWhenUserFinishesAnAction() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(2)).print("Please enter the option:");
    }

    @Test
    public void shouldAllowReEnterWhenUserFinishesTwoAction() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(3)).print("Please enter the option:");
    }

    @Test
    public void shouldStopWhenUserChoosesQuitOption() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(3)).print("Please enter the option:");
        verify(printStream).println("Good bye!");
    }

    @Test
    public void shouldListBooksWhenUserChoosesOptions1() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream).println("List of books:");
        verify(bookStore).listAllBooks();
    }

    @Test
    public void shouldPrintBookDetailsWhenListing() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        Book book = mock(Book.class);
        when(book.getBookDetails()).thenReturn("Book Details");
        when(bookStore.listAllBooks()).thenReturn(Arrays.asList(book));
        biblioteca.start();
        verify(printStream).println("Book Details");
    }

    @Test
    public void shouldAskForTitleBookWhenUserChoosesOption2() throws Exception {
        when(bufferReader.readLine()).thenReturn("2").thenReturn("q");
        biblioteca.start();
        verify(printStream).print("Enter the book you want to checkout:");
    }

    @Test
    public void shouldPrintErrorMessageWhenCheckOutAnUnavailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("2").thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(false);
        biblioteca.start();
        verify(printStream).println("That book is not available.");
    }

    @Test
    public void shouldPrintThankYouMessageWhenCheckOutAnAvailableBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("2").thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.checkoutByTitle("TDD by Example")).thenReturn(true);
        biblioteca.start();
        verify(printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldAskForTitleWhenUserChoosesOption3() throws Exception {
        when(bufferReader.readLine()).thenReturn("3").thenReturn("q");
        biblioteca.start();
        verify(printStream).print("Enter the book you want to return:");
    }

    @Test
    public void shouldPrintErrorMessageWhenReturnAnUnvalidBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("3").thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.returnByTitle("TDD by Example")).thenReturn(false);
        biblioteca.start();
        verify(printStream).println("That is not a valid book to return.");
    }

    @Test
    public void shouldPrintThankYouWhenReturnAnValidBook() throws Exception {
        when(bufferReader.readLine()).thenReturn("3").thenReturn("TDD by Example").thenReturn("q");
        when(bookStore.returnByTitle("TDD by Example")).thenReturn(true);
        biblioteca.start();
        verify(printStream).println("Thank you for returning the book.");
    }
}
