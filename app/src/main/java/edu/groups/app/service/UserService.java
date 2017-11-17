package edu.groups.app.service;

import edu.groups.app.model.User;

/**
 * Created by Kamil on 17/11/2017.
 */

public interface UserService {
    User get();
    void save(User user);
}
