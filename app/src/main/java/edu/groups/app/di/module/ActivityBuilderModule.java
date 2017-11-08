package edu.groups.app.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.ui.main.LoginActivity;
import edu.groups.app.ui.main.LoginActivityModule;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity loginActivityInjector();
}
