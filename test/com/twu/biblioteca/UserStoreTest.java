package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by phuong on 6/01/17.
 */
public class UserStoreTest {

    private List<User> users;
    private User user;

    @Before
    public void setUp() throws Exception {
        users = new ArrayList<User>();
        user = mock(User.class);
        users.add(user);
    }

    @Test
    public void shouldReturnUserWhenUserInfoIsCorrect() throws Exception {
        when(user.checkNameAndPassword("111-1111", "123456")).thenReturn(true);
        User returnUser = new UserStore(users).getUserByNameAndCheckPassword("111-1111", "123456");
        assertEquals(returnUser, user);
    }

    @Test
    public void shouldReturnNullWhenUserInfoIsIncorrect() throws Exception {
        when(user.checkNameAndPassword("111-1111", "")).thenReturn(false);
        User returnUser = new UserStore(users).getUserByNameAndCheckPassword("111-1111", "");
        assertEquals(returnUser, null);
    }
}