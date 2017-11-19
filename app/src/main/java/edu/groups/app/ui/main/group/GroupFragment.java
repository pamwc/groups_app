package edu.groups.app.ui.main.group;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.ui.BaseViewFragment;


public class GroupFragment extends BaseViewFragment<GroupPresenter> implements GroupContract.View {

    @BindView(R.id.group_admin_label)
    TextView adminLabel;

    @BindView(R.id.group_name_label)
    TextView groupNameLabel;

    @BindView(R.id.post_list)
    RecyclerView postList;

    public GroupFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setGroupTutor(String text) {
        adminLabel.setText(text);
    }

    @Override
    public void setGroupName(String text){
        groupNameLabel.setText(text);
    }

}
