package edu.groups.app.navigation;

import android.content.Context;
import android.content.Intent;

import edu.groups.app.ui.group.GroupActivity;
import edu.groups.app.ui.login.LoginActivity;
import edu.groups.app.ui.main.MainActivity;

/**
 * Created by Kamil on 17/11/2017.
 */

public class Navigator {

    public static void openLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public static void openMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public static void openGroupActivity(Context context, long groupId) {
        Intent intent = new Intent(context, GroupActivity.class);
        intent.putExtra(GroupActivity.GROUP_ID, groupId);
        context.startActivity(intent);
    }
}
