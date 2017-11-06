package edu.groups.app.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Kamil on 03/11/2017.
 */

public class UserCredentials extends RealmObject {

    public static final int ID = 1;

    @PrimaryKey
    private int id;
    private String username;
    private String password;

    public UserCredentials() {}

    public UserCredentials(String username, String password) {
        this.id = ID;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
