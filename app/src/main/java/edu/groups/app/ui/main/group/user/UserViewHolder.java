package edu.groups.app.ui.main.group.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.di.module.NetModule;
import edu.groups.app.model.SimpleUser;

/**
 * Created by Dawid Świnoga on 20.11.2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public interface OnRemoveClick {
        void onClick();
    }

    @BindView(R.id.nameAndSurname)
    TextView nameAndSurname;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.userPhoto)
    ImageView userPhoto;
    @BindView(R.id.removeUser)
    ImageButton removeUser;

    private Context context;

    public UserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        context = itemView.getContext();
    }

    public void bind(final SimpleUser simpleUser, OnRemoveClick onRemoveClick) {
        nameAndSurname.setText(String.format("%s %s", simpleUser.getFirstName(), simpleUser.getSurname()));
        username.setText(simpleUser.getUsername());

        Glide.with(context).load(new GlideUrl(NetModule.BASE_URL + "/users/" + simpleUser.getUsername() + "/photo", new LazyHeaders.Builder()
                .addHeader("Authorization", BasicAuthInterceptor.getCredentials())
                .build())).into(userPhoto);
        removeUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRemoveClick.onClick();
            }
        });
    }
}
