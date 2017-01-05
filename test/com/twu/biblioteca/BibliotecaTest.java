package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

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
        verify(printStream).println("q. Quit");
        verify(printStream).println("Please enter the option:");
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
        verify(printStream, times(2)).println("Please enter the option:");
    }


    @Test
    public void shouldAllowReEnterWhenUserFinishesAnAction() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(2)).println("Please enter the option:");
    }

    @Test
    public void shouldAllowReEnterWhenUserFinishesTwoAction() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(3)).println("Please enter the option:");
    }

    @Test
    public void shouldStopWhenUserChoosesQuitOption() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream, times(3)).println("Please enter the option:");
        verify(printStream).println("Good bye!");
    }

    @Test
    public void shouldListBooksWhenUserChoosesOptions1() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(printStream).println("List of books:");
        verify(bookStore).listAllBooks();
    }
}
