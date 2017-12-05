package edu.groups.app.ui.group.comment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.groups.app.R;
import edu.groups.app.model.group.Comment;
import edu.groups.app.ui.group.GroupFragmentContract;
import edu.groups.app.ui.group.post.PostViewHolder;

/**
 * Created by Piotr Borczyk on 05.12.2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private GroupFragmentContract.CommentPresenter commentPresenter;

    public CommentAdapter(GroupFragmentContract.CommentPresenter commentPresenter) {
        this.commentPresenter = commentPresenter;
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        Comment comment = commentPresenter.getComment(position);
        holder.setCommentContent(comment.getContent());
        holder.setUserName(comment.getAuthorUserName());
    }

    @Override
    public int getItemCount() {
        return commentPresenter.getCommentCount();
    }
}
