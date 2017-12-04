package edu.groups.app.ui.group;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.di.FragmentScope;
import edu.groups.app.ui.group.user.UserFragment;
import edu.groups.app.ui.group.user.UserFragmentModule;
import edu.groups.app.ui.group.user.UserListFragment;
import edu.groups.app.ui.group.user.UserListModule;
import edu.groups.app.ui.main.notifications.NotificationListFragment;
import edu.groups.app.ui.main.notifications.NotificationListFragmentModule;
import edu.groups.app.ui.shared.HostActivity;
import edu.groups.app.ui.shared.HostActivityModule;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module(includes = HostActivityModule.class)
public abstract class GroupActivityModule {
    @FragmentScope
    @ContributesAndroidInjector(modules = {GroupFragmentModule.class})
    abstract GroupFragment groupFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {UserFragmentModule.class})
    abstract UserFragment userFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {UserListModule.class})
    abstract UserListFragment userListFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {NotificationListFragmentModule.class})
    abstract NotificationListFragment notificationFragmentInjector();

    @Binds
    @ActivityScope
    abstract HostActivity bindHostActivity(GroupActivity mainActivity);

    @Binds
    @ActivityScope
    abstract GroupContract.View bindViewActivity(GroupActivity mainActivity);
}
