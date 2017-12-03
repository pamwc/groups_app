package edu.groups.app.ui.main.group;

import edu.groups.app.ui.MvpContract;
import edu.groups.app.ui.main.group.adapter.GroupRowView;

/**
 * Created by Kamil on 10/11/2017.
 */

public interface GroupListContract {

    interface View extends MvpContract.View {
        void refresh();
        void showCreateGroupFab();
        void showMessage(String message);
        void openGroupActivity(Long groupId);
    }

    interface Presenter extends MvpContract.Presenter {
        void onBindViewHolder(GroupRowView rowView, int position);
        void onClickGroup(int position);
        void joinGroup(String joinCode);
        void createGroup(String groupName);
        Long getGroupId(int position);
        int getGroupRowsCount();
    }
}
