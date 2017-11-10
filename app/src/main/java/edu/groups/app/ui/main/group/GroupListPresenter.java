package edu.groups.app.ui.main.group;

import edu.groups.app.ui.BasePresenter;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListPresenter extends BasePresenter<GroupListContract.View>
        implements GroupListContract.Presenter {

    public GroupListPresenter(GroupListContract.View view) {
        super(view);
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onDestroy() {

    }
}
