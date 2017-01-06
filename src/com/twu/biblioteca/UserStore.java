package com.twu.biblioteca;

import java.util.List;

/**
 * Created by phuong on 6/01/17.
 */
public class UserStore {

    private final List<User> users;

    public UserStore(List<User> users) {
        this.users = users;
    }

    public User getUserByNameAndCheckPassword(String libraryNumber, String password) {
        return null;
    }
}
