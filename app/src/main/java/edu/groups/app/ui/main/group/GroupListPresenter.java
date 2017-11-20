package edu.groups.app.ui.main.group;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.model.Group;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.group.adapter.GroupRowView;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListPresenter extends InnerPresenter<GroupListContract.View>
        implements GroupListContract.Presenter {

    private final ApiService apiService;
    private final List<Group> groups;

    @Inject
    GroupListPresenter(GroupListContract.View view, UserService userService,
                       ApiService apiService) {
        super(view, userService);
        this.apiService = apiService;
        this.groups = new ArrayList<Group>() {{
            add(new Group("First example group"));
            add(new Group("Second example group"));
        }};
    }

    @Override
    public void onBindViewHolder(GroupRowView rowView, int position) {
        Group group = groups.get(position);
        rowView.setName(group.getName());
    }

    @Override
    public int getGroupRowsCount() {
        return groups.size();
    }
}
