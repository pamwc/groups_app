package edu.groups.app.di.module;

import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.android.DaggerApplication;

/**
 * Created by Kamil on 27/10/2017.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(DaggerApplication application);
}
