package edu.groups.app.ui.group.user;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.FragmentScope;

/**
 * Created by Dawid on 19/11/2017.
 */

@Module
public abstract class UserFragmentModule {

    @Binds
    @FragmentScope
    abstract UserContract.View bindGroupListView(UserFragment userListFragment);

    @Binds
    @FragmentScope
    abstract UserContract.Presenter bindGroupListPresenter(UserPresenter userListPresenter);
}
