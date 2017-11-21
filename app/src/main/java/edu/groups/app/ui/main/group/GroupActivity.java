package edu.groups.app.ui.main.group;

import android.os.Bundle;

import edu.groups.app.R;
import edu.groups.app.ui.shared.HostActivity;

public class GroupActivity extends HostActivity {

    public static final String GROUP_ID = "GROUP_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        replaceFragment(R.id.container, GroupFragment.newInstance(3L));
    }

}
