package edu.groups.app.ui.main.group;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

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
    @BindView(R.id.create_group_fab) FloatingActionButton createGroupFab;

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
        EditText joinCodeInput = new EditText(getActivity());
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder
                .setTitle(R.string.join_group_title)
                .setView(joinCodeInput)
                .setPositiveButton(R.string.dialog_group_pos_btn, (dialog, which) ->
                    presenter.joinGroup(joinCodeInput.getText().toString())
                )
                .setNegativeButton(R.string.dialog_group_neg_btn, (dialog, which) -> {});
        dialogBuilder.show();
    }

    @OnClick(R.id.create_group_fab)
    public void OnClickCreateGroup() {
        EditText groupNameInput = new EditText(getActivity());
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        dialogBuilder
                .setTitle(R.string.create_group_title)
                .setView(groupNameInput)
                .setPositiveButton(R.string.dialog_group_pos_btn, (dialog, which) ->
                        presenter.createGroup(groupNameInput.getText().toString())
                )
                .setNegativeButton(R.string.dialog_group_neg_btn, (dialog, which) -> {});
        dialogBuilder.show();
    }

    private void setUpRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new GroupRecyclerAdapter(presenter));
    }

    @Override
    public void showCreateGroupFab() {
        createGroupFab.setVisibility(View.VISIBLE);
    }

    @Override
    public void refresh() {
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openGroupActivity(Long groupId) {
        Navigator.openGroupActivity(getActivity(), groupId);
    }
}
