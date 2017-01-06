package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * Created by phuong on 6/01/17.
 */
public class DisplayUserInfoOptionTest {
    @Test
    public void shouldRequireLogin() throws Exception {
        assertTrue(new DisplayUserInfoOption("User information").requireLogin());
    }

    @Test
    public void shouldCallDisplayUserInformation() throws Exception {
        User user = mock(User.class);
        Biblioteca biblioteca = mock(Biblioteca.class);
        when(biblioteca.getCurrentUser()).thenReturn(user);
        new DisplayUserInfoOption("UserInformation").execute(biblioteca);
        verify(user).displayUserInformation(biblioteca.getPrintStream());
    }
}