package edu.groups.app.ui.main.group.post;

import android.view.View;

/**
 * Created by howor on 19.11.2017.
 */

public interface PostContract {
    public interface View {
        void setContent(String content);
        void setOnDeleteButtonClick(android.view.View.OnClickListener onClickListener);
        void setOnCommentButtonClick(android.view.View.OnClickListener onClickListener);
    }

    public interface Presenter {

    }
}
