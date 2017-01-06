package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by phuong on 6/01/17.
 */
public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("111-11111", "123456");
    }

    @Test
    public void shouldReturnFalseWhenLibraryNumberIsWrong() throws Exception {
        assertFalse(user.checkNameAndPassword("111-1112", "123456"));
    }

    @Test
    public void shouldReturnFalseWhenPasswordIsWrong() throws Exception {
        assertFalse(user.checkNameAndPassword("111-11111", "12345"));
    }

    @Test
    public void shouldReturnTrueWhenInfoIsCorrect() throws Exception {
        assertTrue(user.checkNameAndPassword("111-11111", "123456"));
    }
}