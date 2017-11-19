package edu.groups.app.ui.main.group;

import java.util.List;

import javax.inject.Inject;

import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.group.post.Comment;
import edu.groups.app.ui.main.group.post.Post;

/**
 * Created by howor on 19.11.2017.
 */

public class GroupPresenter extends InnerPresenter<GroupContract.View> implements GroupContract.Presenter  {

    private List<Post> posts;

    @Inject
    protected GroupPresenter(GroupContract.View view, UserService userService) {
        super(view, userService);
        view.setGroupName("BEST");
        view.setGroupTutor("TJUTOR");
    }

    @Override
    public void deletePost(int postId) {
        posts.remove(postId);
    }

    @Override
    public void commentPost(int postId, Comment comment) {
        posts.get(postId).getComments().add(comment);
    }

    @Override
    public int getPostCount() {
        return posts.size();
    }

    @Override
    public String getPostContent(int postId) {
        return posts.get(postId).getContent();
    }
}
