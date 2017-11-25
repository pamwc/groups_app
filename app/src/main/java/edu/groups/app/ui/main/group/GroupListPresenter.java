package edu.groups.app.ui.main.group;

import com.google.firebase.messaging.FirebaseMessaging;

import org.apache.commons.collections4.CollectionUtils;

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
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListPresenter extends InnerPresenter<GroupListContract.View>
        implements GroupListContract.Presenter {

    private final GroupService groupService;
    private final List<SimpleGroupDto> groups;
    private final Realm realm;

    @Inject
    GroupListPresenter(GroupListContract.View view, UserService userService,
                       GroupService groupService, Realm realm) {
        super(view, userService);
        this.groupService = groupService;
        this.realm = realm;
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
                            unSubscribeAll();
                            groupList.forEach(this::subscribeTopic);
                            groups.addAll(groupList);
                            view.refresh();
                            addToRealm(groupList);
                        }
                );
        disposable.add(subscribe);
    }

    private void addToRealm(List<SimpleGroupDto> groupList) {
        realm.beginTransaction();
        realm.copyToRealm(groupList);
        realm.commitTransaction();
    }

    private void unSubscribeAll() {
        final RealmResults<SimpleGroupDto> groups = realm.where(SimpleGroupDto.class)
                .findAll();
        if (CollectionUtils.isNotEmpty(groups)) {
            groups.forEach(this::unSubscribe);
        }
        realm.beginTransaction();
        realm.delete(SimpleGroupDto.class);
        realm.commitTransaction();
    }

    private void unSubscribe(SimpleGroupDto simpleGroupDto) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(simpleGroupDto.getId().toString());
    }

    private void subscribeTopic(SimpleGroupDto simpleGroupDto) {
        FirebaseMessaging.getInstance().subscribeToTopic(simpleGroupDto.getId().toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
