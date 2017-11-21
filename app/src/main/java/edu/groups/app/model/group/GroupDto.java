
package edu.groups.app.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupDto {

    @SerializedName("adminsUserNames")
    @Expose
    private List<String> adminsUserNames = null;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("membersUserNames")
    @Expose
    private List<String> membersUserNames = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("posts")
    @Expose
    private List<Post> posts = null;

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

    public List<String> getMembersUserNames() {
        return membersUserNames;
    }

    public void setMembersUserNames(List<String> membersUserNames) {
        this.membersUserNames = membersUserNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}
