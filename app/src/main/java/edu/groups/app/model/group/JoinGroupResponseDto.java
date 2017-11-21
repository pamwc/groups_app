
package edu.groups.app.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JoinGroupResponseDto {

    @SerializedName("adminsUserNames")
    @Expose
    private List<String> adminsUserNames = null;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;

    public List<String> getAdminsUserNames() {
        return adminsUserNames;
    }

    public void setAdminsUserNames(List<String> adminsUserNames) {
        this.adminsUserNames = adminsUserNames;
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
