package edu.groups.app.ui.group.user;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.model.User;
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

    @Inject
    public UserListPresenter(UserListContract.View view, UserService userService) {
        super(view, userService);
    }

    @Override
    public User getCurrentUser() {
        return super.getCurrentUser();
    }
}
