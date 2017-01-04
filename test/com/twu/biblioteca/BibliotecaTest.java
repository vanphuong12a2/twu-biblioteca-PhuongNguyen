package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by phuong on 4/01/17.
 */
public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
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
    }

    
}
