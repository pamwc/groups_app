package edu.groups.app.service;

import edu.groups.app.model.User;
import io.realm.Realm.Transaction.OnSuccess;
import java8.util.Optional;

/**
 * Created by Kamil on 04/11/2017.
 */

public interface UserService extends RealmService {
    Optional<User> get();
    void saveAsync(User user, OnSuccess onSuccess);
    void removeAsync(OnSuccess onSuccess);
}
