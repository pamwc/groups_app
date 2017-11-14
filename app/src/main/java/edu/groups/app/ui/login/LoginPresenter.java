package edu.groups.app.ui.login;

import android.util.Log;

import edu.groups.app.api.ApiService;
import edu.groups.app.api.BasicAuthInterceptor;
import edu.groups.app.model.BasicCredentials;
import edu.groups.app.model.User;
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

    private final BasicAuthInterceptor interceptor;
    private final UserService userService;
    private final ApiService apiService;

    public LoginPresenter(LoginContract.View view, BasicAuthInterceptor interceptor,
                          UserService userService, ApiService apiService) {
        super(view);
        this.interceptor = interceptor;
        this.userService = userService;
        this.apiService = apiService;
    }

    @Override
    public void onResume() {
        userService.get().ifPresent(user ->
                loginRequest(user.getCredentials())
        );
    }

    @Override
    public void onDestroy() {
        userService.dispatch();
    }

    @Override
    public void login(BasicCredentials credentials) {
        loginRequest(credentials);
    }

    @Override
    public void logout() {
        userService.removeAsync(() ->
                view.showMessage("Logout!")
        );
    }

    private void loginRequest(BasicCredentials credentials) {
        interceptor.storeCredentials(credentials);
        apiService.aboutMe().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG, "Response code: " + response.code());
                if (response.isSuccessful()) {
                    User user = response.body();
                    user.setCredentials(credentials);
                    Log.e(TAG, user.getCredentials().getPassword());
                    userService.saveAsync(user, () ->
                            view.showMessage("Welcome, " + response.body().getFirstName())
                    );
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
