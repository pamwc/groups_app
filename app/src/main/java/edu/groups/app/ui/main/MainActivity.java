package edu.groups.app.ui.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.ui.main.account.AccountFragment;
import edu.groups.app.ui.main.group.GroupListFragment;
import edu.groups.app.ui.shared.HostActivity;

/**
 * Created by Kamil on 09/11/2017.
 */

public class MainActivity extends HostActivity {

    @BindView(R.id.navigation) BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            replaceFragment(R.id.fragment_container, new GroupListFragment());
        }

        navigationView.setOnNavigationItemSelectedListener(
                this::onNavigationItemSelectedListener
        );
    }

    private boolean onNavigationItemSelectedListener(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_groups:
                replaceFragment(R.id.fragment_container, new GroupListFragment());
                return true;
            case R.id.navigation_my_account:
                replaceFragment(R.id.fragment_container, new AccountFragment());
                return true;
            default:
                return false;
        }
    }
}
