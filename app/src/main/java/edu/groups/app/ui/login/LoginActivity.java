package edu.groups.app.ui.login;

import android.os.Bundle;

import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;
import edu.groups.app.model.BasicCredentials;
import edu.groups.app.navigation.Navigator;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {

    private static final String USERNAME = "jan";
    private static final String PASSWORD = "test";

    @Inject LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        FirebaseMessaging.getInstance().subscribeToTopic("foo-bar");
    }

    @OnClick(R.id.login)
    public void onClickLogin() {
        presenter.login(new BasicCredentials(USERNAME, PASSWORD));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void openMainActivity() {
        Navigator.openMainActivity(this);
    }
}
