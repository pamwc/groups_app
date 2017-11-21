package edu.groups.app.ui.login;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.model.BasicCredentials;
import edu.groups.app.repository.UserRealmRepository;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.BasePresenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Kamil on 28/10/2017.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    private static final String TAG = LoginPresenter.class.getName();

    private final BasicAuthInterceptor authInterceptor;
    private final UserService userService;
    private final UserRealmRepository userRealmRepository;
    private final ApiService apiService;

    @Inject
    LoginPresenter(LoginContract.View view, BasicAuthInterceptor authInterceptor,
                   UserRealmRepository userRealmRepository, UserService userService,
                   ApiService apiService) {
        super(view);
        this.authInterceptor = authInterceptor;
        this.userRealmRepository = userRealmRepository;
        this.userService = userService;
        this.apiService = apiService;

        initDisposableResources();
    }

    @Override
    public void onResume() {
        userRealmRepository.get().ifPresent(user ->
                login(user.getCredentials())
        );
    }

    @Override
    public void login(BasicCredentials credentials) {
        view.showMessage("Loading...");
        authInterceptor.storeCredentials(credentials);
        Disposable subscribe = apiService.aboutMe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            user.setCredentials(credentials);
                            userRealmRepository.saveAsync(user, () -> {
                                userService.save(user);
                                view.openMainActivity();
                            });
                        },
                        error -> {
                            view.showMessage("Invalid username or password");
                        }
                );
        disposable.add(subscribe);
    }

    private void initDisposableResources() {
        disposable.add(userRealmRepository);
    }
}
