package edu.groups.app.ui.main;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.groups.app.api.ApiService;
import edu.groups.app.service.AuthService;

/**
 * Created by Kamil on 28/10/2017.
 */

@Module
public abstract class MainActivityModule {

    @Binds
    abstract MainContract.View bindMainView(MainActivity mainActivity);

    @Provides
    static MainContract.Presenter provideMainPresenter(MainContract.View view, AuthService authService,
                                                       ApiService apiService) {
        return new MainPresenter(view, authService, apiService);
    }
}
