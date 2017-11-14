package edu.groups.app.ui.login;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.di.ActivityScope;
import edu.groups.app.service.UserService;

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
    static LoginContract.Presenter provideLoginPresenter(LoginContract.View view, BasicAuthInterceptor interceptor,
                                                         UserService userService, ApiService apiService) {
        return new LoginPresenter(view, interceptor, userService, apiService);
    }
}
