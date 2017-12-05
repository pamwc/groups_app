package edu.groups.app.ui.main.notifications.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import edu.groups.app.R;
import edu.groups.app.model.Notification;
import edu.groups.app.model.NotificationDto;
import edu.groups.app.ui.main.notifications.NotificationListContract;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {

    private NotificationListContract.Presenter presenter;

    @Inject
    public NotificationAdapter(NotificationListContract.Presenter presenter) {
        this.presenter = presenter;
        setHasStableIds(true);
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotificationViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.fragment_notification, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        NotificationDto notification = presenter.getNotification(position);
        holder.setCommentContent(notification.getContent());
        holder.setCommentTitle(notification.getTitle());
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleClick(position);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        NotificationDto notification = presenter.getNotification(position);
        switch (notification.getNotificationType()) {
            case POST:
                return notification.getPostId();
            case COMMENT:
                return notification.getCommentId();
            default:
                return 0L;
        }
    }

    @Override
    public int getItemCount() {
        return presenter.getNotificationCount();
    }


}
