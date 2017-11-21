
package edu.groups.app.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("authorUserName")
    @Expose
    private String authorUserName;
    @SerializedName("child")
    @Expose
    private Child child;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("creationTime")
    @Expose
    private String creationTime;
    @SerializedName("id")
    @Expose
    private Long id;

    public String getAuthorUserName() {
        return authorUserName;
    }

    public void setAuthorUserName(String authorUserName) {
        this.authorUserName = authorUserName;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

}
