package edu.groups.app.ui.group;

import android.content.Intent;
import android.os.Bundle;

import edu.groups.app.R;
import edu.groups.app.ui.group.user.UserFragment;
import edu.groups.app.ui.shared.HostActivity;

public class GroupActivity extends HostActivity implements GroupContract.View {

    public static final String GROUP_ID = "GROUP_ID";
    public static final String POST_ID = "post.id";
    public static final String COMMENT_ID = "comment.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        Intent intent = getIntent();
        long groupId = intent.getLongExtra(GROUP_ID, GroupFragment.NO_GROUP_ID);
        groupId = intent.getLongExtra(GROUP_ID, GroupFragment.NO_GROUP_ID);
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
