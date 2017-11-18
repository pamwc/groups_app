package edu.groups.app.ui.login;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.ActivityScope;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class LoginActivityModule {

    @Binds
    @ActivityScope
    abstract LoginContract.View bindLoginView(LoginActivity loginActivity);

    @Binds
    @ActivityScope
    abstract LoginContract.Presenter provideLoginPresenter(LoginPresenter loginPresenter);
}
