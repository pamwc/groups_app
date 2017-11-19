package edu.groups.app.ui.main.group;

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
    abstract GroupContract.View bindGroupListView(GroupFragment groupFragment);

    @Binds
    @FragmentScope
    abstract GroupContract.Presenter bindGroupListPresenter(GroupPresenter groupPresenter);
}
