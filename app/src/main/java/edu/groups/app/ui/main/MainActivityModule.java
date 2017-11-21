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
import edu.groups.app.ui.main.group.user.UserFragment;
import edu.groups.app.ui.main.group.user.UserFragmentModule;
import edu.groups.app.ui.main.group.user.UserListFragment;
import edu.groups.app.ui.main.group.user.UserListModule;
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
    @ContributesAndroidInjector(modules = {UserFragmentModule.class})
    abstract UserFragment userFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {UserListModule.class})
    abstract UserListFragment userListFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = {AccountFragmentModule.class})
    abstract AccountFragment accountFragmentInjector();

    @Binds
    @ActivityScope
    abstract HostActivity bindHostActivity(MainActivity mainActivity);
}
