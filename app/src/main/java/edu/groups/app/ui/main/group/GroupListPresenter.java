package edu.groups.app.ui.main.group;

import javax.inject.Inject;

import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListPresenter extends InnerPresenter<GroupListContract.View>
        implements GroupListContract.Presenter {

    @Inject
    GroupListPresenter(GroupListContract.View view, UserService userService) {
        super(view, userService);
    }

    @Override
    public void onResume() {
        super.onResume();
        view.showMessage(getCurrentUser().getFirstName());
    }
}
