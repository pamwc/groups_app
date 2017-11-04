package edu.groups.app.di;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import edu.groups.app.di.module.ActivityBuilderModule;
import edu.groups.app.di.module.AppModule;
import edu.groups.app.di.module.RepositoryModule;

/**
 * Created by Kamil on 27/10/2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        RepositoryModule.class,
        ActivityBuilderModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<DaggerApplication> {}
}
