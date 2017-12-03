package edu.groups.app.ui.main.notifications;


import java.util.List;

import javax.inject.Inject;

import edu.groups.app.model.Notification;
import edu.groups.app.model.NotificationDto;
import edu.groups.app.repository.NotificationRealmRepository;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.notifications.adapter.NotificationAdapter;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

public class NotificationListPresenter extends InnerPresenter<NotificationListContract.View> implements NotificationListContract.Presenter {

    private UserService userService;
    private NotificationRealmRepository notificationRepository;
    private List<NotificationDto> notifications;

    @Inject
    public NotificationListPresenter(NotificationListContract.View view, UserService userService, NotificationRealmRepository notificationRepository) {
        super(view, userService);
        this.userService = userService;
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void onResume() {
        setPostAdapter();
        notificationRepository.getAll()
                .subscribe(notificationList -> {
                    notifications = notificationList;
                    uiUpdate();
                });
        super.onResume();
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
    public void deleteNotification(int position) {
        NotificationDto notification = notifications.get(position);
        notificationRepository.removeAsync(notification, null);
    }
}
