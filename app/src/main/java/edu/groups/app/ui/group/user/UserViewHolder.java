package edu.groups.app.ui.group.user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.api.GroupService;
import edu.groups.app.di.module.NetModule;
import edu.groups.app.model.SimpleUser;
import edu.groups.app.model.User;
import edu.groups.app.model.UserRole;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dawid Świnoga on 20.11.2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    private final User currentUser;
    private final boolean removeButtonEnabled;
    private final GroupService groupService;
    private final Long groupId;

    public interface SuccessRemoveAction {

        void removeUser(SimpleUser user);
    }

    @BindView(R.id.nameAndSurname)
    TextView nameAndSurname;

    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.userPhoto)
    ImageView userPhoto;
    @BindView(R.id.removeUser)
    ImageButton removeUserButton;
    @BindView(R.id.progressBar)
    View progressBar;

    private Context context;

    public UserViewHolder(View itemView, User currentUser, Long groupId, GroupService groupService) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.groupService = groupService;
        this.groupId = groupId;
        this.context = itemView.getContext();
        this.currentUser = currentUser;
        this.removeButtonEnabled = currentUser.hasRole(UserRole.ADMIN);
    }

    public void bind(final SimpleUser simpleUser, SuccessRemoveAction removeAction) {
        nameAndSurname.setText(String.format("%s %s", simpleUser.getFirstName(), simpleUser.getSurname()));
        username.setText(simpleUser.getUsername());

        Glide.with(context).load(new GlideUrl(NetModule.BASE_URL + "/users/" + simpleUser.getUsername() + "/photo", new LazyHeaders.Builder()
                .addHeader("Authorization", BasicAuthInterceptor.getCredentials())
                .build())).into(userPhoto);

        if (removeButtonEnabled && !isCurrentLoginUser(simpleUser)) {
            removeUserButton.setVisibility(View.VISIBLE);
            removeUserButton.setOnClickListener(v -> {
                        progressBar.setVisibility(View.VISIBLE);
                        removeUserButton.setClickable(false);
                        onRemoveClick(simpleUser, removeAction);

                    }
            );
        }
    }

    private void onRemoveClick(SimpleUser simpleUser, SuccessRemoveAction removeAction) {
        groupService.removeUserFromGroup(groupId, simpleUser.getUsername())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> removeAction.removeUser(simpleUser), onRemoveError());
    }

    @NonNull
    private Consumer<Throwable> onRemoveError() {
        return throwable -> {
            Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_SHORT).show();
            removeUserButton.setClickable(true);
            progressBar.setVisibility(View.GONE);
        };
    }


    private boolean isCurrentLoginUser(SimpleUser simpleUser) {
        return simpleUser.getUsername().equals(currentUser.getCredentials().getUsername());
    }

    void recycle() {
        removeUserButton.setOnClickListener(null);
    }
}
