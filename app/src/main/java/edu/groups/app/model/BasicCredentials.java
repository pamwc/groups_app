package edu.groups.app.model;

import io.realm.RealmObject;

/**
 * Created by Kamil on 03/11/2017.
 */

public class BasicCredentials extends RealmObject {

    private String username;
    private String password;

    public BasicCredentials() {}

    public BasicCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
