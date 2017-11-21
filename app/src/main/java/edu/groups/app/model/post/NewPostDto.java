
package edu.groups.app.model.post;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewPostDto {

    @SerializedName("commentEnabled")
    @Expose
    private Boolean commentEnabled;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("title")
    @Expose
    private String title;

    public Boolean getCommentEnabled() {
        return commentEnabled;
    }

    public void setCommentEnabled(Boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
