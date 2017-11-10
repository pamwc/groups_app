package edu.groups.app.ui.main;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.di.FragmentScope;
import edu.groups.app.ui.main.group.GroupListFragment;
import edu.groups.app.ui.main.group.GroupListFragmentModule;
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

    @Binds
    @ActivityScope
    abstract HostActivity bindHostActivity(MainActivity mainActivity);
}
