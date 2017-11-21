package edu.groups.app.ui.main.group.post;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.groups.app.R;

/**
 * Created by howor on 18.11.2017.
 */

public class PostViewHolder extends RecyclerView.ViewHolder implements PostContract.View {

    @BindView(R.id.post_title)
    TextView postTitle;

    @BindView(R.id.post_creation_date)
    TextView postCreationDate;

    @BindView(R.id.post_author)
    TextView postAuthor;

    @BindView(R.id.post_content)
    TextView postContent;

    @BindView(R.id.comment_list)
    RecyclerView commentList;

    @BindView(R.id.delete_button)
    Button deleteButton;

    @BindView(R.id.comment_button)
    Button commentButton;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setTitle(String title) {
        postTitle.setText(title);
    }

    @Override
    public void setContent(String content) {
        postContent.setText(content);
    }

    @Override
    public void setAuthor(String author) {
        postAuthor.setText(author);
    }

    @Override
    public void setCreationDate(String creationDate) {
        postCreationDate.setText(creationDate);
    }

    @Override
    public void setOnDeleteButtonClick(View.OnClickListener onClickListener) {
        deleteButton.setOnClickListener(onClickListener);
    }

    @Override
    public void setOnCommentButtonClick(View.OnClickListener onClickListener) {
        commentButton.setOnClickListener(onClickListener);
    }

    @Override
    public void setCommentsEnabled(boolean commentsEnabled) {
        commentButton.setEnabled(commentsEnabled);
        commentButton.setClickable(commentsEnabled);
    }
}
