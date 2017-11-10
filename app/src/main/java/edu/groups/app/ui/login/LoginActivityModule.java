package edu.groups.app.ui.login;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.groups.app.api.ApiService;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.service.AuthService;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class LoginActivityModule {

    @Binds
    @ActivityScope
    abstract LoginContract.View bindLoginView(LoginActivity loginActivity);

    @Provides
    @ActivityScope
    static LoginContract.Presenter provideLoginPresenter(LoginContract.View view, AuthService authService,
                                                         ApiService apiService) {
        return new LoginPresenter(view, authService, apiService);
    }
}
