package edu.groups.app.service;

import edu.groups.app.model.User;

/**
 * Created by Kamil on 17/11/2017.
 */

public class InMemoryUserService implements UserService {

    private User user;

    @Override
    public User get() {
        return user;
    }

    @Override
    public void save(User user) {
        this.user = user;
    }
}
