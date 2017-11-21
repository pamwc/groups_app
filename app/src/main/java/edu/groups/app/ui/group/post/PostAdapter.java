package edu.groups.app.ui.group.post;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import edu.groups.app.R;
import edu.groups.app.model.group.Post;
import edu.groups.app.ui.group.GroupFragmentContract;

/**
 * Created by howor on 18.11.2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    @Inject
    public PostAdapter(GroupFragmentContract.Presenter groupPresenter) {
        this.groupPresenter = groupPresenter;
        setHasStableIds(true);
    }

    private GroupFragmentContract.Presenter groupPresenter;

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = groupPresenter.getPost(position);
        holder.setTitle(post.getTitle());
        holder.setAuthor(post.getAuthorUserName());
        holder.setCreationDate(post.getCreationTime());
        holder.setContent(post.getContent());
        holder.setCommentsEnabled(post.getCommentEnabled());
        holder.setOnDeleteButtonClick(v -> {
            groupPresenter.deletePost(position);
        });
        holder.setOnCommentButtonClick(v -> groupPresenter.commentPost(position, new Comment()));
    }

    @Override
    public int getItemCount() {
        return groupPresenter.getPostCount();
    }

    @Override
    public long getItemId(int position) {
        return groupPresenter.getPost(position).getId();
    }
}
