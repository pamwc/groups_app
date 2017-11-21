package edu.groups.app.ui.group;

import android.os.Bundle;

import edu.groups.app.R;
import edu.groups.app.ui.group.user.UserFragment;
import edu.groups.app.ui.shared.HostActivity;

public class GroupActivity extends HostActivity implements GroupContract.View {

    public static final String GROUP_ID = "GROUP_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        long groupId = getIntent().getLongExtra(GROUP_ID, GroupFragment.NO_GROUP_ID);
        if (savedInstanceState == null) {
            replaceFragment(R.id.container, GroupFragment.newInstance(groupId, this));
        }
    }

    @Override
    public void openGroupMembers(Bundle bundle) {
        UserFragment userFragment = new UserFragment();
        userFragment.setArguments(bundle);
        replaceFragment(R.id.container, userFragment);
    }
}
