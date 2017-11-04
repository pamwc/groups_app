package edu.groups.app.service;

import io.realm.Realm;

/**
 * Created by Kamil on 04/11/2017.
 */

public class AuthServiceImpl implements AuthService {

    private final Realm realm;

    public AuthServiceImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void close() {
        realm.close();
    }
}
