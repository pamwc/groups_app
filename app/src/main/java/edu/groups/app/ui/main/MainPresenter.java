package edu.groups.app.ui.main;

import android.util.Log;

import edu.groups.app.api.ApiService;
import edu.groups.app.model.User;
import edu.groups.app.model.UserCredentials;
import edu.groups.app.service.AuthService;
import edu.groups.app.ui.BasePresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kamil on 28/10/2017.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getName();

    private final AuthService authService;
    private final ApiService apiService;

    public MainPresenter(MainContract.View view, AuthService authService, ApiService apiService) {
        super(view);
        this.authService = authService;
        this.apiService = apiService;
    }

    @Override
    public void onResume() {
        loginRequest();
    }

    @Override
    public void onDestroy() {
        authService.dispatch();
    }

    @Override
    public void login(final String username, final String password) {
        authService.storeCredentialsAsync(
                new UserCredentials(username, password), this::loginRequest
        );
    }

    @Override
    public void logout() {
        authService.clearCredentialsAsync(
                () -> view.showMessage("Logout successful")
        );
    }

    private void loginRequest() {
        apiService.aboutMe().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.i(TAG, "Response code: " + response.code());
                if (response.isSuccessful()) {
                    view.showMessage("Welcome, " + response.body().getUsername());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }
}
