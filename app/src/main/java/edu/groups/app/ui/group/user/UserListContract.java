package edu.groups.app.ui.group.user;

import edu.groups.app.model.User;
import edu.groups.app.ui.MvpContract;

/**
 * Created by Dawid Świnoga on 21.11.2017.
 */

public interface UserListContract {
    public interface Presenter extends MvpContract.Presenter {
        User getCurrentUser();
    }

    public interface View extends MvpContract.Presenter, MvpContract.View {

    }
}
