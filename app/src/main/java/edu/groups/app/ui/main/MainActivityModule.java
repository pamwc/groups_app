package edu.groups.app.ui.main;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.ui.shared.HostActivity;
import edu.groups.app.ui.shared.HostActivityModule;

/**
 * Created by Kamil on 09/11/2017.
 */

@Module(includes = HostActivityModule.class)
public abstract class MainActivityModule {

    @Binds
    @ActivityScope
    abstract HostActivity bindHostActivity(MainActivity mainActivity);
}
