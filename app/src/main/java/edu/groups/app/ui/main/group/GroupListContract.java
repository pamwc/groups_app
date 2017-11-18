package edu.groups.app.ui.main.group;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Kamil on 10/11/2017.
 */

public interface GroupListContract {

    interface View extends MvpContract.View {
        void showMessage(String message);
    }

    interface Presenter extends MvpContract.Presenter {

    }
}
