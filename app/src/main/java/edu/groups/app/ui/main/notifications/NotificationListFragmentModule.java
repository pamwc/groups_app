package edu.groups.app.ui.main.notifications;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.FragmentScope;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

@Module
public abstract class NotificationListFragmentModule {

    @Binds
    @FragmentScope
    abstract NotificationListContract.Presenter bindsNotifiationListPresenter(NotificationListPresenter notificationListPresenter);

    @Binds
    @FragmentScope
    abstract NotificationListContract.View bindsNotificationListView(NotificationListFragment notificationListFragment);
}
