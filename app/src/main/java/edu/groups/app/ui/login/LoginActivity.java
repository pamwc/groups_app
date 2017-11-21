package edu.groups.app.ui.login;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;
import edu.groups.app.model.BasicCredentials;
import edu.groups.app.navigation.Navigator;

public class LoginActivity extends DaggerAppCompatActivity implements LoginContract.View {

    @Inject LoginContract.Presenter presenter;

    @BindView(R.id.text) TextView textView;

    @BindView(R.id.login_input)
    EditText login_input;

    @BindView(R.id.password_input)
    EditText password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        FirebaseMessaging.getInstance().subscribeToTopic("foo-bar");
    }

    @OnClick(R.id.login)
    public void onClickLogin() {
        presenter.login(new BasicCredentials(
                login_input.getText().toString(), password_input.getText().toString()
        ));
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
    public void showMessage(String message) {
        textView.setText(message);
    }

    @Override
    public void openMainActivity() {
        Navigator.openMainActivity(this);
    }
}
