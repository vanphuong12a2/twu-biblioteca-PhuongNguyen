package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by phuong on 4/01/17.
 */
public class BibliotecaTest {

    private final ListBooksOption listBooksOption = mock(ListBooksOption.class);
    private final CheckoutBookOption checkoutBookOption = mock(CheckoutBookOption.class);
    private final ReturnBookOption returnBookOption = mock(ReturnBookOption.class);
    private final ListMoviesOption listMoviesOption = mock(ListMoviesOption.class);
    private final CheckoutMovieOption checkoutMovieOption = mock(CheckoutMovieOption.class);
    private final LoginOption loginOption = mock(LoginOption.class);
    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BufferedReader bufferReader;
    private List<MenuOption> menuOptions = new ArrayList<MenuOption>();


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        menuOptions.add(listBooksOption);
        menuOptions.add(checkoutBookOption);
        menuOptions.add(returnBookOption);
        menuOptions.add(listMoviesOption);
        menuOptions.add(checkoutMovieOption);
        menuOptions.add(loginOption);
        when(bufferReader.readLine()).thenReturn("q");
        biblioteca = new Biblioteca(mock(BookStore.class), mock(MovieStore.class), mock(UserStore.class), menuOptions, printStream, bufferReader);
    }

    @Test
    public void shouldPrintWelcomeMessageWhenStarting() throws Exception {
        biblioteca.start();
        verify(printStream).println(Biblioteca.WELCOME_TO_BIBLIOTECA);
    }

    @Test
    public void shouldPrintMainMenuWhenStarting() throws Exception {
        when(listBooksOption.getDescription()).thenReturn("List books");
        when(checkoutBookOption.getDescription()).thenReturn("Checkout book");
        when(returnBookOption.getDescription()).thenReturn("Return book");
        when(listMoviesOption.getDescription()).thenReturn("List movies");
        biblioteca.start();
        verify(printStream).println("List of options:");
        verify(printStream).println("1. List books");
        verify(printStream).println("2. Checkout book");
        verify(printStream).println("3. Return book");
        verify(printStream).println("4. List movies");
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
    public void shouldCallListsBookExecuteWhenUserChoosesOptions1() throws Exception {
        when(bufferReader.readLine()).thenReturn("1").thenReturn("q");
        biblioteca.start();
        verify(listBooksOption).execute(biblioteca);
    }

    @Test
    public void shouldCallCheckoutBookExecuteWhenUserChoosesOption2() throws Exception {
        when(bufferReader.readLine()).thenReturn("2").thenReturn("q");
        biblioteca.start();
        verify(checkoutBookOption).execute(biblioteca);
    }

    @Test
    public void shouldCallReturnBookOptionExecuteWhenUserChoosesOption3() throws Exception {
        when(bufferReader.readLine()).thenReturn("3").thenReturn("q");
        biblioteca.start();
        verify(returnBookOption).execute(biblioteca);
    }

    @Test
    public void shouldCallListMoviesOptionExecuteWhenUserChoosesOption4() throws Exception {
        when(bufferReader.readLine()).thenReturn("4").thenReturn("q");
        biblioteca.start();
        verify(listMoviesOption).execute(biblioteca);
    }

    @Test
    public void shouldCallCheckoutMovieExecuteWhenUserChoosesOption5() throws Exception {
        when(bufferReader.readLine()).thenReturn("5").thenReturn("q");
        biblioteca.start();
        verify(checkoutMovieOption).execute(biblioteca);
    }

    @Test
    public void shouldCallLoginExecuteWhenUserChoosesOption6() throws Exception {
        when(bufferReader.readLine()).thenReturn("6").thenReturn("q");
        biblioteca.start();
        verify(loginOption).execute(biblioteca);
    }
}
