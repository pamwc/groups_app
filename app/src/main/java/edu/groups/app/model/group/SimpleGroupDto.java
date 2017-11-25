
package edu.groups.app.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SimpleGroupDto extends RealmObject{

    @SerializedName("adminsUserNames")
    @Expose
    private RealmList<String> adminsUserNames = null;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("id")
    @Expose
    @PrimaryKey
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;

    public List<String> getAdminsUserNames() {
        return adminsUserNames;
    }

    public void setAdminsUserNames(List<String> adminsUserNames) {
        this.adminsUserNames = new RealmList<>();
        this.adminsUserNames.addAll(adminsUserNames);
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
