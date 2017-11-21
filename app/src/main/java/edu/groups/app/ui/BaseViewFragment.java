package edu.groups.app.ui;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by Kamil on 10/11/2017.
 */

public abstract class BaseViewFragment<T extends MvpContract.Presenter> extends DaggerFragment
        implements MvpContract.View {

    @Inject
    protected T presenter;

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
