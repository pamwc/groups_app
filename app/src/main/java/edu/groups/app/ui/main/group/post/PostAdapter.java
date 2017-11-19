package edu.groups.app.ui.main.group.post;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.groups.app.R;
import edu.groups.app.ui.main.group.GroupContract;

/**
 * Created by howor on 18.11.2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
    private GroupContract.Presenter groupPresenter;

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.setContent(groupPresenter.getPostContent(position));
        holder.setOnDeleteButtonClick(v -> groupPresenter.deletePost(position));
        holder.setOnDeleteButtonClick(v -> groupPresenter.commentPost(position, new Comment()));
    }

    @Override
    public int getItemCount() {
        return groupPresenter.getPostCount();
    }
}
