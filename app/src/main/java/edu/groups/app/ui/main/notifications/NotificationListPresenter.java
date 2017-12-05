package edu.groups.app.ui.main.notifications;


import java.util.List;

import javax.inject.Inject;

import edu.groups.app.api.NotificationsService;
import edu.groups.app.model.NotificationDto;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.notifications.adapter.NotificationAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

public class NotificationListPresenter extends InnerPresenter<NotificationListContract.View> implements NotificationListContract.Presenter {

    private UserService userService;
    private List<NotificationDto> notifications;
    private NotificationsService notificationsService;

    @Inject
    public NotificationListPresenter(NotificationListContract.View view, UserService userService, NotificationsService notificationsService) {
        super(view, userService);
        this.userService = userService;
        this.notificationsService = notificationsService;
    }

    @Override
    public void onResume() {
        super.onResume();
        Disposable notificationsDisposable = loadNotifications();
        disposable.add(notificationsDisposable);
    }

    public Disposable loadNotifications() {
        return notificationsService.getNotifications().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(notificationDtos -> {
                    notifications = notificationDtos;
                    setPostAdapter();
                    uiUpdate();
                });
    }

    private void uiUpdate() {
        view.notifyDataSetChanged();
    }

    private void setPostAdapter() {
        NotificationAdapter adapter = new NotificationAdapter(this);
        view.setAdapter(adapter);
    }

    @Override
    public int getNotificationCount() {
        return notifications.size();
    }

    @Override
    public NotificationDto getNotification(int position) {
        return notifications.get(position);
    }

    @Override
    public void handleClick(int position) {
        NotificationDto notification = notifications.get(position);
        view.startActivity(notification.getGroupId(), notification.getPostId(), notification.getCommentId());
    }
}
