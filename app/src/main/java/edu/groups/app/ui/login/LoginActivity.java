package edu.groups.app.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;
import edu.groups.app.ui.main.MainActivity;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {

    private static final String USERNAME = "jan";
    private static final String PASSWORD = "test";

    @Inject
    LoginContract.Presenter presenter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseMessaging.getInstance().subscribeToTopic("foo-bar");
        textView = (TextView) findViewById(R.id.text);

        final Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(view -> presenter.login(USERNAME, PASSWORD));

        final Button logoutButton = (Button) findViewById(R.id.logout);
        logoutButton.setOnClickListener(view -> presenter.logout());
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
    public void showMessage(String something) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
