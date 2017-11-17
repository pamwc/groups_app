package edu.groups.app.ui.login;

import android.util.Log;

import javax.inject.Inject;

import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.model.BasicCredentials;
import edu.groups.app.model.User;
import edu.groups.app.repository.UserRealmRepository;
import edu.groups.app.service.UserService;
import edu.groups.app.ui.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    }

    @Override
    public void onResume() {
        userRealmRepository.get().ifPresent(user ->
                login(user.getCredentials())
        );
    }

    @Override
    public void onDestroy() {
        userRealmRepository.dispatch();
    }

    @Override
    public void login(BasicCredentials credentials) {
        authInterceptor.storeCredentials(credentials);
        apiService.aboutMe().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG, "Response code: " + response.code());
                if (response.isSuccessful()) {
                    User user = response.body();
                    user.setCredentials(credentials);

                    userRealmRepository.saveAsync(user, () -> {
                        userService.save(user);
                        view.openMainActivity();
                    });
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
