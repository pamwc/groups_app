package edu.groups.app.ui.main.group.user;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.groups.app.R;
import edu.groups.app.api.ApiService;
import edu.groups.app.model.SimpleUser;
import io.reactivex.Observable;

import static java8.util.Optional.ofNullable;

/**
 * Created by Dawid Świnoga on 20.11.2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<SimpleUser> users;
    private OnUserRemove onUserRemove;

    public interface OnUserRemove {
        void onRemove(String username);
    }

    public UserAdapter(List<SimpleUser> users, OnUserRemove onUserRemove) {
        this.users = ofNullable(users).orElseGet(ArrayList::new);
        this.onUserRemove = onUserRemove;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bind(users.get(position), () -> {
            final SimpleUser user = users.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, users.size());
            onUserRemove.onRemove(user.getUsername());
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
