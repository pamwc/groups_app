package edu.groups.app.ui.main;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.di.FragmentScope;
import edu.groups.app.ui.main.account.AccountFragment;
import edu.groups.app.ui.main.account.AccountFragmentModule;
import edu.groups.app.ui.main.group.GroupListFragment;
import edu.groups.app.ui.main.group.GroupListFragmentModule;
import edu.groups.app.ui.main.notifications.NotificationListFragment;
import edu.groups.app.ui.main.notifications.NotificationListFragmentModule;
import edu.groups.app.ui.shared.HostActivity;
import edu.groups.app.ui.shared.HostActivityModule;

/**
 * Created by Kamil on 09/11/2017.
 */

@Module(includes = HostActivityModule.class)
public abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = {GroupListFragmentModule.class})
    abstract GroupListFragment groupListFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {AccountFragmentModule.class})
    abstract AccountFragment accountFragmentInjector();

    @Binds
    @ActivityScope
    abstract HostActivity bindHostActivity(MainActivity mainActivity);

    @FragmentScope
    @ContributesAndroidInjector(modules = {NotificationListFragmentModule.class})
    abstract NotificationListFragment notficationListInjectior();
}
