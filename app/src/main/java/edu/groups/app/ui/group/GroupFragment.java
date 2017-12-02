package edu.groups.app.ui.group;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.groups.app.R;
import edu.groups.app.model.post.NewPostDto;
import edu.groups.app.ui.BaseViewFragment;
import edu.groups.app.ui.group.post.AddPostDialog;
import edu.groups.app.ui.group.post.PostAdapter;
import edu.groups.app.ui.group.user.UserFragment;
import edu.groups.app.ui.group.user.UserPagerAdapter;


public class GroupFragment extends BaseViewFragment<GroupFragmentContract.Presenter> implements GroupFragmentContract.View {

    public static final String GROUP_ID = "GROUP_ID";
    public static final long NO_GROUP_ID = 0L;

    @BindView(R.id.group_admin_label)
    TextView adminLabel;

    @BindView(R.id.group_name_label)
    TextView groupNameLabel;

    @BindView(R.id.post_list)
    RecyclerView postList;

    private GroupContract.View groupView;
    private long groupId;

    public GroupFragment() {
    }

    @Override
    public void onResume() {
        presenter.setGroupId(groupId);
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    private void setGroupView(GroupContract.View groupView) {
        this.groupView = groupView;
    }

    public static GroupFragment newInstance(Long groupId, GroupContract.View groupView) {
        GroupFragment fragment = new GroupFragment();
        fragment.setGroupView(groupView);
        Bundle args = new Bundle();
        args.putLong(GROUP_ID, groupId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);
        ButterKnife.bind(this, view);
        if (getArguments() != null) {
            groupId = getArguments().getLong(GROUP_ID);
        }
        postList.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @OnClick(R.id.members_button)
    public void onClickShowMembersButton() {
        List<String> admins = presenter.getGroupAdmins();
        List<String> members = presenter.getGroupMembers();

        Bundle bundle = new Bundle();
        bundle.putLong(UserPagerAdapter.GROUP_ID, groupId);
        bundle.putStringArrayList(UserFragment.USERNAME_ADMINS, new ArrayList<>(admins));
        bundle.putStringArrayList(UserFragment.USERNAME_STUDENTS, new ArrayList<>(members));
        groupView.openGroupMembers(bundle);
    }

    @Override
    public void setGroupTutor(String text) {
        adminLabel.setText(text);
    }

    @Override
    public void setAdapter(PostAdapter adapter) {
        postList.setAdapter(adapter);
    }

    @Override
    public void notifyAdapterPostAdded() {
        postList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void notifyAdapterPostDeleted(int position) {
        postList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void setGroupName(String text){
        groupNameLabel.setText(text);
    }

    @OnClick(R.id.add_post_button)
    public void onAddPostButtonClick(View addPostButton) {
        AddPostDialog addPostDialog = new AddPostDialog(getActivity());
        addPostDialog.setOnResultListener(new AddPostDialog.OnResultListener() {
            @Override
            public void result(NewPostDto newPostDto) {
                presenter.addPost(newPostDto);
            }
        });
        addPostDialog.show();
    }

}
