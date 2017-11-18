package edu.groups.app.ui.main.account;

import javax.inject.Inject;

import edu.groups.app.model.User;
import edu.groups.app.repository.UserRealmRepository;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.InnerPresenter;

/**
 * Created by Kamil on 17/11/2017.
 */

public class AccountPresenter extends InnerPresenter<AccountContract.View>
        implements AccountContract.Presenter {

    private final UserRealmRepository userRealmRepository;

    @Inject
    AccountPresenter(AccountContract.View view, UserService userService,
                     UserRealmRepository userRealmRepository) {
        super(view, userService);
        this.userRealmRepository = userRealmRepository;
    }

    @Override
    public void onResume() {
        super.onResume();
        User user = getCurrentUser();
        view.showFullName(user.getFirstName() + " " + user.getSurname());
    }

    @Override
    public void logout() {
        userRealmRepository.removeAsync(view::openLoginActivity);
    }
}
