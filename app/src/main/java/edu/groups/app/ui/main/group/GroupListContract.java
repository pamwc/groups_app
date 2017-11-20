package edu.groups.app.ui.main.group;

import edu.groups.app.ui.MvpContract;
import edu.groups.app.ui.main.group.adapter.GroupRowView;

/**
 * Created by Kamil on 10/11/2017.
 */

public interface GroupListContract {

    interface View extends MvpContract.View {
    }

    interface Presenter extends MvpContract.Presenter {
        void onBindViewHolder(GroupRowView rowView, int position);
        int getGroupRowsCount();
    }
}
