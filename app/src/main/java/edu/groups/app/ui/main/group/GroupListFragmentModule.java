package edu.groups.app.ui.main.group;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.groups.app.di.FragmentScope;

/**
 * Created by Kamil on 10/11/2017.
 */

@Module
public abstract class GroupListFragmentModule {

    @Binds
    @FragmentScope
    abstract GroupListContract.View bindGroupListView(GroupListFragment groupListFragment);

    @Provides
    @FragmentScope
    static GroupListContract.Presenter provideGroupListPresenter(GroupListContract.View view) {
        return new GroupListPresenter(view);
    }
}
