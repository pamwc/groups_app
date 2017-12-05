package edu.groups.app.ui.group.post;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import edu.groups.app.R;
import edu.groups.app.model.User;
import edu.groups.app.model.UserRole;
import edu.groups.app.model.group.Comment;
import edu.groups.app.model.group.Post;
import edu.groups.app.ui.group.GroupFragmentContract;
import edu.groups.app.ui.group.comment.CommentAdapter;

/**
 * Created by howor on 18.11.2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private User currentUser;

    @Inject
    public PostAdapter(GroupFragmentContract.Presenter groupPresenter) {
        this.groupPresenter = groupPresenter;
        this.currentUser = groupPresenter.getCurrentUser();
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
        holder.setOnCommentButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                groupPresenter.commentPost(position);
            }
        });
        if (currentUser.hasRole(UserRole.ADMIN)) {
            holder.showDeleteButton();
            holder.setOnDeleteButtonClick(v ->
                    groupPresenter.deletePost(position)
            );
        }
        holder.setCommentListAdapter(new CommentAdapter(getCommentPresenter(post)));
        holder.setCommentListLayoutManager(new LinearLayoutManager(groupPresenter.getContext()){
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

    }

    private GroupFragmentContract.CommentPresenter getCommentPresenter(Post post) {
        return new GroupFragmentContract.CommentPresenter() {
            @Override
            public Comment getComment(int position) {
                return post.getComments().get(position);
            }

            @Override
            public int getCommentCount() {
                return post.getComments().size();
            }
        };
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
