package edu.groups.app.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Kamil on 27/10/2017.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);
}
