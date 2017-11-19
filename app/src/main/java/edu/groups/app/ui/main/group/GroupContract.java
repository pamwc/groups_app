package edu.groups.app.ui.main.group;

import edu.groups.app.ui.MvpContract;
import edu.groups.app.ui.main.group.post.Comment;
import edu.groups.app.ui.main.group.post.PostContract;

/**
 * Created by howor on 19.11.2017.
 */

public interface GroupContract {

    interface View extends MvpContract.View {
        void setGroupName(String name);
        void setGroupTutor(String groupTutor);
    }

    interface Presenter extends MvpContract.Presenter {
        void deletePost(int postId);
        void commentPost(int postId, Comment comment);
        int getPostCount();
        String getPostContent(int postId);
    }
}
