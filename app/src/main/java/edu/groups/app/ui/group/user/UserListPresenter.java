package edu.groups.app.ui.group.user;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Dawid Świnoga on 21.11.2017.
 */

public class UserListPresenter extends InnerPresenter<UserListContract.View>
        implements UserListContract.Presenter {
    private Long groupId;
    private ApiService apiService;

    @Inject
    public UserListPresenter(UserListContract.View view, UserService userService, ApiService apiService) {
        super(view, userService);
        this.apiService = apiService;
    }

    @Override
    public void removeUser(String username) {
        Disposable subscribe = apiService.removeUserFromGroup(groupId, username)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> view.showToast("User: " + username + " deleted"));
        disposable.add(subscribe);
    }

    @Override
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
