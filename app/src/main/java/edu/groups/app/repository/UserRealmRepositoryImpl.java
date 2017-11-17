package edu.groups.app.repository;

import edu.groups.app.model.User;
import io.realm.Realm;
import io.realm.Realm.Transaction.OnSuccess;
import java8.util.Optional;

/**
 * Created by Kamil on 04/11/2017.
 */

public class UserRealmRepositoryImpl implements UserRealmRepository {

    private final Realm realm;

    public UserRealmRepositoryImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public Optional<User> get() {
        User user = realm.where(User.class)
                .equalTo("id", User.ID)
                .findFirst();
        return Optional.ofNullable(user);
    }

    @Override
    public void saveAsync(User user, OnSuccess onSuccess) {
        user.setId(User.ID);
        realm.executeTransactionAsync(
                realm1 -> realm1.insertOrUpdate(user), onSuccess
        );
    }

    @Override
    public void removeAsync(OnSuccess onSuccess) {
        realm.executeTransactionAsync(
                realm1 -> realm1.delete(User.class), onSuccess
        );
    }

    @Override
    public void dispatch() {
        realm.close();
    }
}
