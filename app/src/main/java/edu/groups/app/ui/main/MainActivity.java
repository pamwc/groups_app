package edu.groups.app.ui.main;

import android.os.Bundle;

import edu.groups.app.R;
import edu.groups.app.ui.main.group.GroupListFragment;
import edu.groups.app.ui.shared.HostActivity;

/**
 * Created by Kamil on 09/11/2017.
 */

public class MainActivity extends HostActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            replaceFragment(R.id.fragment_container, new GroupListFragment());
        }
    }
}
