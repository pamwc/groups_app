package edu.groups.app.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Kamil on 05/11/2017.
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class User extends RealmObject {

    public static final int ID = 1;

    @PrimaryKey
    private int id;
    private String firstName;
    private String surname;
    private BasicCredentials credentials;
    private RealmList<String> roles;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = new RealmList<>();
        this.roles.addAll(roles);
    }
}
