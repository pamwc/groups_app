package edu.groups.app.ui.main.account;

import dagger.Binds;
import dagger.Module;
import edu.groups.app.di.FragmentScope;

/**
 * Created by Kamil on 17/11/2017.
 */

@Module
public abstract class AccountFragmentModule {

    @Binds
    @FragmentScope
    abstract AccountContract.View bindAccountView(AccountFragment accountFragment);

    @Binds
    @FragmentScope
    abstract AccountContract.Presenter bindAccountPresenter(AccountPresenter accountPresenter);
}
