package edu.groups.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import edu.groups.app.dependency.DaggerAppComponent;

/**
 * Created by Kamil on 27/10/2017.
 */

public class GroupsApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }
}
