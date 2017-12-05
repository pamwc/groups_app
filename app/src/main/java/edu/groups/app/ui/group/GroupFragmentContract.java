package edu.groups.app.ui.group;

import android.content.Context;

import java.util.List;

import edu.groups.app.model.User;
import edu.groups.app.model.group.Comment;
import edu.groups.app.model.group.Post;
import edu.groups.app.model.post.NewPostDto;
import edu.groups.app.ui.MvpContract;
import edu.groups.app.ui.group.post.PostAdapter;

/**
 * Created by howor on 19.11.2017.
 */

public interface GroupFragmentContract {

    interface View extends MvpContract.View {
        void setGroupName(String name);
        void setGroupTutor(String groupTutor);
        void setAdapter(PostAdapter adapter);
        void notifyAdapterPostAdded();
        void notifyAdapterPostDeleted(int position);

        void showError(String message);

        void showJoinCodeDialog(String code);

        void showLeaveGroupDialog();

        void openCommentDialog(Long id);

        Context getContext();
    }

    interface Presenter extends MvpContract.Presenter {
        User getCurrentUser();
        void addPost(NewPostDto newPostDto);

        void deletePost(int postId);
        int getPostCount();
        void setGroupId(long groupId);
        Post getPost(int position);

        List<String> getGroupAdmins();
        List<String> getGroupMembers();

        void leaveGroupClick();

        void joinCodeClick();

        void resetCode();

        List<String> currentUserRole();

        void leaveGroup();

        void commentPost(int position);

        void addComment(Long postId, String content);

        Context getContext();
    }

    interface CommentPresenter {

        Comment getComment(int position);

        int getCommentCount();
    }

}
