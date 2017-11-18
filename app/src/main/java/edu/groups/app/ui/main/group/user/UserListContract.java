package edu.groups.app.ui.main.group.user;

import edu.groups.app.ui.MvpContract;

/**
 * Created by Dawid Świnoga on 21.11.2017.
 */

public interface UserListContract {
    public interface Presenter extends MvpContract.Presenter {
        void removeUser(String username);

        void setGroupId(Long groupId);
    }

    public interface View extends MvpContract.Presenter, MvpContract.View {
        void showToast(String text);
    }
}
