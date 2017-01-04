package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by phuong on 4/01/17.
 */
public class BibliotecaTest {
    @Test
    public void shouldPrintWelcomeMessageWhenStarted() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Biblioteca biblioteca = new Biblioteca(printStream);
        biblioteca.start();
        verify(printStream).println(Biblioteca.WELCOME_TO_BIBLIOTECA);
    }
}
