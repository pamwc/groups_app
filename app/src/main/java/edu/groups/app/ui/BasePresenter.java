package edu.groups.app.ui;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Kamil on 28/10/2017.
 */

public abstract class BasePresenter<T extends MvpContract.View> implements MvpContract.Presenter {

    protected final T view;
    protected final CompositeDisposable disposable;

    protected BasePresenter(T view) {
        this.view = view;
        this.disposable = new CompositeDisposable();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        disposable.clear();
    }
}
