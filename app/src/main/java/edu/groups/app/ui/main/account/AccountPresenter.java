package edu.groups.app.ui.main.account;

import javax.inject.Inject;

import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;

/**
 * Created by Kamil on 17/11/2017.
 */

public class AccountPresenter extends InnerPresenter<AccountContract.View>
        implements AccountContract.Presenter {

    @Inject
    AccountPresenter(AccountContract.View view, UserService userService) {
        super(view, userService);
    }
}
