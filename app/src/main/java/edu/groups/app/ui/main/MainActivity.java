package edu.groups.app.ui.main;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {

    private static final String USERNAME = "jan";
    private static final String PASSWORD = "test";

    @Inject
    MainContract.Presenter presenter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        textView.setText(something);
    }
}
