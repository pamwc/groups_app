package edu.groups.app.ui.main;

import edu.groups.app.ui.BasePresenter;

/**
 * Created by Kamil on 28/10/2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void doSomething() {
        view.showSomething("MVP with Dagger2.11 ;)");
    }
}
