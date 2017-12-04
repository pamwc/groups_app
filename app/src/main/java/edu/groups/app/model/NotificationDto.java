
package edu.groups.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotificationDto {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("commentId")
    @Expose
    private Integer commentId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("groupId")
    @Expose
    private Integer groupId;
    @SerializedName("notificationType")
    @Expose
    private NotificationType notificationType;
    @SerializedName("postId")
    @Expose
    private Integer postId;
    @SerializedName("title")
    @Expose
    private String title;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
