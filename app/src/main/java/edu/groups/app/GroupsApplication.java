package edu.groups.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import edu.groups.app.di.DaggerAppComponent;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Kamil on 27/10/2017.
 */

public class GroupsApplication extends DaggerApplication {

    public static final String REALM_FILE = "groupsApp.realm";

    @Override
    public void onCreate() {
        super.onCreate();
        initRealmConfiguration();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfiguration
                = new RealmConfiguration.Builder()
                    .name(REALM_FILE)
                    .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
