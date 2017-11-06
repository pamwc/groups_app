package edu.groups.app.service;

import edu.groups.app.model.UserCredentials;
import io.realm.Realm.Transaction.OnSuccess;

/**
 * Created by Kamil on 04/11/2017.
 */

public interface AuthService extends RealmService {
    void storeCredentialsAsync(UserCredentials credentials, OnSuccess onSuccess);
    void clearCredentialsAsync(OnSuccess onSuccess);
}
