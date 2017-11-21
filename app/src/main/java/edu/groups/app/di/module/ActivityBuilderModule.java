package edu.groups.app.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.ui.login.LoginActivity;
import edu.groups.app.ui.login.LoginActivityModule;
import edu.groups.app.ui.main.MainActivity;
import edu.groups.app.ui.main.MainActivityModule;
import edu.groups.app.ui.main.group.GroupActivity;
import edu.groups.app.ui.main.group.GroupActivityModule;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = {LoginActivityModule.class})
    abstract LoginActivity loginActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = {GroupActivityModule.class})
    abstract GroupActivity groupActivityInjector();
}
