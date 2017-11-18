package edu.groups.app.ui.shared;

import android.app.FragmentManager;
import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.groups.app.di.ActivityScope;

/**
 * Created by Kamil on 09/11/2017.
 */

@Module
public abstract class HostActivityModule {

    @Binds
    @ActivityScope
    abstract Context bindContext(HostActivity hostActivity);

    @Provides
    @ActivityScope
    static FragmentManager provideFragmentManager(HostActivity hostActivity) {
        return hostActivity.getFragmentManager();
    }
}
