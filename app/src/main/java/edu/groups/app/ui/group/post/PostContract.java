package edu.groups.app.ui.group.post;

/**
 * Created by howor on 19.11.2017.
 */

public interface PostContract {
    public interface View {
        void setTitle(String title);
        void setContent(String content);
        void setAuthor(String author);
        void setCreationDate(String creationDate);
        void setOnDeleteButtonClick(android.view.View.OnClickListener onClickListener);
        void setOnCommentButtonClick(android.view.View.OnClickListener onClickListener);
        void setCommentsEnabled(boolean commentsEnabled);
    }

    public interface Presenter {

    }
}
