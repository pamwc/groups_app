package edu.groups.app.ui.group.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.api.GroupService;
import edu.groups.app.model.SimpleUser;
import edu.groups.app.ui.BaseViewFragment;

import static edu.groups.app.ui.group.user.UserPagerAdapter.GROUP_ID;
import static edu.groups.app.ui.group.user.UserPagerAdapter.USERS;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserListFragment extends BaseViewFragment<UserListContract.Presenter>
        implements UserListContract.View {
    private UserAdapter userAdapter;
    private List<SimpleUser> users;
    private Long groupId;

    @BindView(R.id.users)
    RecyclerView recyclerView;

    @Inject
    GroupService groupService;

    public UserListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_user_list, container, false);
        ButterKnife.bind(this, view);
        initArg();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setAutoMeasureEnabled(true);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        userAdapter = new UserAdapter(users, groupService, presenter.getCurrentUser(), groupId);
        recyclerView.setAdapter(userAdapter);

        return view;
    }

    private void initArg() {
        final Bundle arguments = getArguments();
        users = arguments.getParcelableArrayList(USERS);
        groupId = arguments.getLong(GROUP_ID);

    }
}
