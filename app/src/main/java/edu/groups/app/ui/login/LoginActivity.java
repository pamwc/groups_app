package edu.groups.app.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;
import edu.groups.app.model.BasicCredentials;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {

    private static final String USERNAME = "jan";
    private static final String PASSWORD = "test";

    @Inject LoginContract.Presenter presenter;

    @BindView(R.id.text) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        FirebaseMessaging.getInstance().subscribeToTopic("foo-bar");

        final Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(view -> presenter.login(
                new BasicCredentials(USERNAME, PASSWORD)
        ));

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
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
    }
}
