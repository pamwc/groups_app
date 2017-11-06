package edu.groups.app.service;

import edu.groups.app.model.UserCredentials;
import io.realm.Realm;
import io.realm.Realm.Transaction.OnSuccess;

/**
 * Created by Kamil on 04/11/2017.
 */

public class AuthServiceImpl implements AuthService {

    private final Realm realm;

    public AuthServiceImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void storeCredentialsAsync(UserCredentials credentials, OnSuccess onSuccess) {
        realm.executeTransactionAsync(
                realm1 -> realm1.insertOrUpdate(credentials), onSuccess
        );
    }

    @Override
    public void clearCredentialsAsync(OnSuccess onSuccess) {
        realm.executeTransactionAsync(
                realm1 -> realm1.delete(UserCredentials.class), onSuccess
        );
    }

    @Override
    public void dispatch() {
        realm.close();
    }
}
