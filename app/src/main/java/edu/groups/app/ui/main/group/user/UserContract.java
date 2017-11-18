package edu.groups.app.ui.main.group.user;

import java.util.ArrayList;
import java.util.List;

import edu.groups.app.model.SimpleUser;
import edu.groups.app.ui.MvpContract;

/**
 * Created by Dawid Świnoga on 19.11.2017.
 */

public interface UserContract {
    public interface View extends MvpContract.View{
        void publishUsers(List<SimpleUser> admins, List<SimpleUser> students);
    }

    public interface Presenter extends MvpContract.Presenter{
        void loadUsers(List<String> admins, List<String> students);

        void setGroupId(Long groupId);

        Long getGroupId();
    }
}
