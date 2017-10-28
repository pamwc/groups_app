package edu.groups.app.ui.main;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import edu.groups.app.R;

public class MainActivity extends DaggerAppCompatActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.doSomething();
    }

    @Override
    public void showSomething(String something) {
        textView.setText(something);
    }
}
