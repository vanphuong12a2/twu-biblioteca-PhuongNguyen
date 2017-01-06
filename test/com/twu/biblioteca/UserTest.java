package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by phuong on 6/01/17.
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("111-1111", "123456", "Ally Miles", "ally@gmail.com", "Barcelona, Spain");
    }

    @Test
    public void shouldReturnFalseWhenLibraryNumberIsWrong() throws Exception {
        assertFalse(user.checkNameAndPassword("111-1112", "123456"));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsWrong() throws Exception {
        assertFalse(user.checkNameAndPassword("111-1111", "12345"));
    }

    @Test
    public void shouldReturnTrueWhenInfoIsCorrect() throws Exception {
        assertTrue(user.checkNameAndPassword("111-1111", "123456"));
    }

    @Test
    public void shouldDisplayAllUserInformation() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        user.displayUserInformation(printStream);
        verify(printStream).println("User information:");
        verify(printStream).println("User name      Ally Miles");
        verify(printStream).println("Email          ally@gmail.com");
        verify(printStream).println("Address        Barcelona, Spain");

    }
}