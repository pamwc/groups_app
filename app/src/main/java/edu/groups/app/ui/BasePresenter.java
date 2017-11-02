package edu.groups.app.ui;

/**
 * Created by Kamil on 28/10/2017.
 */

public abstract class BasePresenter<T extends MvpContract.View> implements MvpContract.Presenter {

    protected final T view;

    protected BasePresenter(T view) {
        this.view = view;
    }
}
