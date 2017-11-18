package edu.groups.app.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Kamil on 05/11/2017.
 */

public class User extends RealmObject {

    public static final int ID = 1;

    @PrimaryKey
    private int id;
    private String firstName;
    private String surname;
    private BasicCredentials credentials;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public BasicCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(BasicCredentials credentials) {
        this.credentials = credentials;
    }
}
