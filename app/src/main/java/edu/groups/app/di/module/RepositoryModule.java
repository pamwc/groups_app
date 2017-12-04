package edu.groups.app.di.module;

import dagger.Module;
import dagger.Provides;
import edu.groups.app.repository.UserRealmRepository;
import edu.groups.app.repository.UserRealmRepositoryImpl;
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
    static UserRealmRepository provideRealmUserRepository(Realm realm) {
        return new UserRealmRepositoryImpl(realm);
    }
}
