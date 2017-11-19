package edu.groups.app.ui.main.group.post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by howor on 19.11.2017.
 */

public class Post {
    private String content;
    private List<Comment> comments = new ArrayList<>();

    public List<Comment> getComments() {
        return comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
