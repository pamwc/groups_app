package edu.groups.app.di.module;

import dagger.Module;
import dagger.Provides;
import edu.groups.app.service.UserService;
import edu.groups.app.service.UserServiceImpl;
import io.realm.Realm;

/**
 * Created by Kamil on 04/11/2017.
 */

@Module
public abstract class RepositoryModule {

    @Provides
    static Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

    @Provides
    static UserService provideUserService(Realm realm) {
        return new UserServiceImpl(realm);
    }
}
