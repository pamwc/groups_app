package edu.groups.app.ui.group.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.groups.app.model.SimpleUser;

import static java8.util.Optional.ofNullable;

/**
 * Created by Dawid Świnoga on 19.11.2017.
 */

public class UserPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 2;
    public static final String USERS = "users";
    public static final String GROUP_ID = "group.id";
    private final ArrayList<SimpleUser> admins;
    private final ArrayList<SimpleUser> students;
    private Long groupId;

    public UserPagerAdapter(FragmentManager fm, List<SimpleUser> admins, List<SimpleUser> students,
                            Long groupId) {
        super(fm);
        this.admins = getUserOrEmpty(admins);
        this.students = getUserOrEmpty(students);
        this.groupId = groupId;
    }

    private ArrayList<SimpleUser> getUserOrEmpty(List<SimpleUser> admins) {
        return ofNullable(admins).map(ArrayList::new).orElseGet(ArrayList::new);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment adminFragment = new UserListFragment();
                adminFragment.setArguments(createBundle(admins));
                return adminFragment;
            case 1:
                Fragment userFragment = new UserListFragment();
                userFragment.setArguments(createBundle(students));
                return userFragment;
            default:
                return null;
        }
    }

    private Bundle createBundle(ArrayList<SimpleUser> users) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(USERS, users);
        bundle.putLong(GROUP_ID, groupId);
        return bundle;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
