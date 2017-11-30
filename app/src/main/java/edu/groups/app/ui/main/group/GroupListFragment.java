package edu.groups.app.ui.main.group;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.groups.app.R;
import edu.groups.app.navigation.Navigator;
import edu.groups.app.ui.BaseViewFragment;
import edu.groups.app.ui.main.group.adapter.GroupRecyclerAdapter;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListFragment extends BaseViewFragment<GroupListContract.Presenter>
        implements GroupListContract.View {

    @BindView(R.id.group_list) RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);
        ButterKnife.bind(this, view);
        setUpRecyclerView();
        return view;
    }

    @OnClick(R.id.join_group_fab)
    public void onClickJoinGroup() {
        Log.e("GroupListFragment", "Button 'join' was pressed.");
    }

    @OnClick(R.id.create_group_fab)
    public void OnClickCreateGroup() {
        Log.e("GroupListFragment", "Button 'create' was pressed.");
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new GroupRecyclerAdapter(presenter));
    }

    @Override
    public void refresh() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void openGroupActivity(Long groupId) {
        Navigator.openGroupActivity(getActivity(), groupId);
    }
}
