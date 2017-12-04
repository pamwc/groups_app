package edu.groups.app.ui.group.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.groups.app.R;
import edu.groups.app.api.GroupService;
import edu.groups.app.model.SimpleUser;
import edu.groups.app.model.User;
import java8.util.Optional;

import static java8.util.Optional.ofNullable;
import static java8.util.stream.StreamSupport.stream;

/**
 * Created by Dawid Świnoga on 20.11.2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<SimpleUser> users;
    private GroupService groupService;
    private final User currentUser;
    private final Long groupId;

    public interface OnUserRemove {
        void onRemove(String username);
    }

    public UserAdapter(List<SimpleUser> users, GroupService groupService, User currentUser, Long groupId) {
        this.users = ofNullable(users).orElseGet(ArrayList::new);
        this.groupService = groupService;
        this.currentUser = currentUser;
        this.groupId = groupId;
    }

    @Override
    public void onViewRecycled(UserViewHolder holder) {
        super.onViewRecycled(holder);
        holder.recycle();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(view, currentUser, groupId, groupService);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(users.get(position), this::removeUser);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void removeUser(String username) {
        final Optional<SimpleUser> simpleUser = stream(users)
                .filter(that -> that.getUsername().equals(username))
                .findFirst();

        simpleUser.ifPresent(this::removeUser);
    }

    private void removeUser(SimpleUser simpleUser) {
        final int position = users.indexOf(simpleUser);
        users.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, users.size());
    }

    public void setUsers(List<SimpleUser> users) {
        this.users = users;
    }
}
