package edu.groups.app.ui.main.group.user;

import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.model.SimpleUser;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static java8.util.stream.Collectors.groupingBy;
import static java8.util.stream.StreamSupport.stream;

/**
 * Created by Dawid Świnoga on 19.11.2017.
 */

public class UserPresenter extends InnerPresenter<UserContract.View>
        implements UserContract.Presenter {
    private ApiService apiService;
    private Long groupId;

    @Inject
    public UserPresenter(UserContract.View view, UserService userService, ApiService apiService) {
        super(view, userService);
        this.apiService = apiService;
    }


    @Override
    public void loadUsers(List<String> admins, List<String> students) {
        final boolean ADMINS = true;
        final boolean USERS = false;
        List<String> users = ListUtils.union(admins, students);
        users.addAll(students);
        Disposable subscribe = apiService.getUsers(StringUtils.join(users, ","))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(that -> {
                    final Map<Boolean, List<SimpleUser>> collect = stream(that)
                            .collect(groupingBy(user -> admins.contains(user.getUsername())));
                    view.publishUsers(collect.get(ADMINS), collect.get(USERS));
                });
        disposable.add(subscribe);


    }

    @Override
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    @Override
    public Long getGroupId() {
        return groupId;
    }
}
