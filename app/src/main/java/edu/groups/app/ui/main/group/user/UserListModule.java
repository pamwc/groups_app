package edu.groups.app.ui.main.group.user;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.FragmentScope;

/**
 * Created by Dawid Świnoga on 21.11.2017.
 */
@Module
public abstract class UserListModule {
    @Binds
    @FragmentScope
    abstract UserListContract.View bindGroupListView(UserListFragment userListFragment);

    @Binds
    @FragmentScope
    abstract UserListContract.Presenter bindGroupListPresenter(UserListPresenter userListPresenter);
}
