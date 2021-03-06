package edu.groups.app.ui.main.account;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Kamil on 17/11/2017.
 */

public interface AccountContract {

    interface View extends MvpContract.View {
        void showFullName(String fullName);
        void openLoginActivity();
    }

    interface Presenter extends MvpContract.Presenter {
        void logout();
    }
}
