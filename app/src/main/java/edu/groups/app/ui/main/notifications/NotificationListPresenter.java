package edu.groups.app.ui.main.notifications;

import javax.inject.Inject;

import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

public class NotificationListPresenter extends InnerPresenter<NotificationListContract.View> implements NotificationListContract.Presenter {

    @Inject
    public NotificationListPresenter(NotificationListContract.View view, UserService userService) {
        super(view, userService);
    }
}
