package edu.groups.app.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.ui.main.MainActivity;
import edu.groups.app.ui.main.MainActivityModule;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();
}
