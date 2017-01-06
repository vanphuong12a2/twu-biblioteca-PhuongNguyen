package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by phuong on 6/01/17.
 */
public class LoginOptionTest {

    private static final List<MenuOption> EMPTY_MENU = new ArrayList<MenuOption>();
    private PrintStream printStream;
    private BufferedReader bufferReader;
    private Biblioteca biblioteca;
    private LoginOption loginOption;
    private UserStore userStore;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferReader = mock(BufferedReader.class);
        userStore = mock(UserStore.class);
        biblioteca = new Biblioteca(mock(BookStore.class), mock(MovieStore.class), userStore, EMPTY_MENU, printStream, bufferReader);
        loginOption = new LoginOption("Login");
    }

    @Test
    public void shouldAskForIDAndPassworldWhenExecuting() throws Exception {
        loginOption.execute(biblioteca);
        verify(printStream).print("Enter your library number:");
        verify(printStream).print("Enter your password:");
        verify(bufferReader, times(2)).readLine();
    }

    @Test
    public void shoudReturnMessageAndSetUserWhenLoginInfoIsCorrect() throws Exception {
        when(bufferReader.readLine()).thenReturn("111-1111").thenReturn("123456");
        User user = mock(User.class);
        when(userStore.getUserByNameAndCheckPassword("111-1111", "123456")).thenReturn(user);
        loginOption.execute(biblioteca);
        verify(printStream).println("You have logged in!");
        assertEquals(biblioteca.getCurrentUser(), user);
    }

    @Test
    public void shouldPrintErrorMessageWhenLoginInfoIsIncorrect() throws Exception {
        when(bufferReader.readLine()).thenReturn("111-1111").thenReturn("123456");
        when(userStore.getUserByNameAndCheckPassword("111-1111", "123456")).thenReturn(null);
        loginOption.execute(biblioteca);
        verify(printStream).println("Wrong library number or password!");
    }

    @Test
    public void shouldNotRequireLogin() throws Exception {
        assertFalse(loginOption.requireLogin());
    }
}