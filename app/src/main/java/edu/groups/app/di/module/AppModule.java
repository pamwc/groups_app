package edu.groups.app.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.DaggerApplication;
import edu.groups.app.service.InMemoryUserService;
import edu.groups.app.service.UserService;

/**
 * Created by Kamil on 27/10/2017.
 */

@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(DaggerApplication application);

    @Provides
    @Singleton
    static UserService provideUserService() {
        return new InMemoryUserService();
    }
}
