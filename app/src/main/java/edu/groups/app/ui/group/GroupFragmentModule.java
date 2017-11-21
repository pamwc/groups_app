package edu.groups.app.ui.group;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.FragmentScope;

/**
 * Created by howor on 19.11.2017.
 */

@Module
public abstract class GroupFragmentModule {
    @Binds
    @FragmentScope
    abstract GroupFragmentContract.View bindGroupListView(GroupFragment groupFragment);

    @Binds
    @FragmentScope
    abstract GroupFragmentContract.Presenter bindGroupListPresenter(GroupPresenter groupPresenter);
}
