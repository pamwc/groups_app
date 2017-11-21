package edu.groups.app.ui.group.user;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.model.SimpleUser;
import edu.groups.app.ui.BaseViewFragment;

import static edu.groups.app.ui.group.user.UserPagerAdapter.GROUP_ID;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseViewFragment<UserContract.Presenter>
        implements UserContract.View, TabLayout.OnTabSelectedListener {
    public static final String USERNAME_ADMINS = "username.admins";
    public static final String USERNAME_STUDENTS = "username.students";
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @BindView(R.id.pager)
    ViewPager viewPager;

    public UserFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_user, container, false);
        ButterKnife.bind(this, view);
        initArgs();
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tutors));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.students));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(this);
        return view;
    }

    private void initArgs() {
        presenter.loadUsers(getArguments().getStringArrayList(USERNAME_ADMINS),
                getArguments().getStringArrayList(USERNAME_STUDENTS));
        presenter.setGroupId(getArguments().getLong(GROUP_ID));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void publishUsers(List<SimpleUser> admins, List<SimpleUser> students) {
        UserPagerAdapter adapter = new UserPagerAdapter(getActivity().getSupportFragmentManager(),
                admins, students, presenter.getGroupId());
        viewPager.setAdapter(adapter);
    }
}
