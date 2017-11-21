package edu.groups.app.ui.main.group;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import edu.groups.app.api.GroupService;
import edu.groups.app.model.group.SimpleGroupDto;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import edu.groups.app.ui.main.group.adapter.GroupRowView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListPresenter extends InnerPresenter<GroupListContract.View>
        implements GroupListContract.Presenter {

    private final GroupService groupService;
    private final List<SimpleGroupDto> groups;

    @Inject
    GroupListPresenter(GroupListContract.View view, UserService userService,
                       GroupService groupService) {
        super(view, userService);
        this.groupService = groupService;
        this.groups = new ArrayList<>();
    }

    @Override
    public void onResume() {
        super.onResume();
        fetchMyGroups();
    }

    @Override
    public void onBindViewHolder(GroupRowView rowView, int position) {
        SimpleGroupDto group = groups.get(position);
        rowView.setName(group.getName());
    }

    @Override
    public void onClickGroup(int position) {
        SimpleGroupDto group = groups.get(position);
        view.openGroupActivity(group.getId());
    }

    @Override
    public Long getGroupId(int position) {
        return groups.get(position).getId();
    }

    @Override
    public int getGroupRowsCount() {
        return groups.size();
    }

    private void fetchMyGroups() {
        Disposable subscribe = groupService.getCurrentUserSimpleGroup()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        groupList -> {
                            groups.clear();
                            groups.addAll(groupList);
                            view.refresh();
                        }
                );
        disposable.add(subscribe);
    }
}
