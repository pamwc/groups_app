package edu.groups.app.ui;

import edu.groups.app.model.User;
import edu.groups.app.service.UserService;

/**
 * Created by Kamil on 17/11/2017.
 */

public abstract class InnerPresenter<T extends MvpContract.View> extends BasePresenter<T> {

    private final UserService userService;

    public InnerPresenter(T view, UserService userService) {
        super(view);
        this.userService = userService;
    }

    protected User getCurrentUser() {
        return userService.get();
    }
}
