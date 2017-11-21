package edu.groups.app.ui.group;

import android.os.Bundle;

import edu.groups.app.R;
import edu.groups.app.ui.shared.HostActivity;

public class GroupActivity extends HostActivity {

    public static final String GROUP_ID = "GROUP_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long groupId = getIntent().getLongExtra(GROUP_ID, GroupFragment.NO_GROUP_ID);
        setContentView(R.layout.activity_group);
        replaceFragment(R.id.container, GroupFragment.newInstance(groupId));
    }

}
