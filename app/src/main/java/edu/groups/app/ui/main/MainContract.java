package edu.groups.app.ui.main;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Kamil on 28/10/2017.
 */

public interface MainContract {

    interface View extends MvpContract.View {
        void showSomething(String something);
    }

    interface Presenter extends MvpContract.Presenter {
        void doSomething();
    }
}