package edu.groups.app.ui.login;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Kamil on 28/10/2017.
 */

public interface LoginContract {

    interface View extends MvpContract.View {
        void showMessage(String message);
    }

    interface Presenter extends MvpContract.Presenter {
        void login(String username, String password);
        void logout();
    }
}
