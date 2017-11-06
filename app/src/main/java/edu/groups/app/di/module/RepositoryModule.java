package edu.groups.app.di.module;

import dagger.Module;
import dagger.Provides;
import edu.groups.app.service.AuthService;
import edu.groups.app.service.AuthServiceImpl;
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
    static AuthService provideAccountService(Realm realm) {
        return new AuthServiceImpl(realm);
    }
}
