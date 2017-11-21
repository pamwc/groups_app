package edu.groups.app.ui.main.group.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import edu.groups.app.R;
import edu.groups.app.ui.main.group.GroupListContract;

/**
 * Created by Kamil on 20/11/2017.
 */

public class GroupRecyclerAdapter extends RecyclerView.Adapter<GroupViewHolder> {

    private final GroupListContract.Presenter presenter;

    public GroupRecyclerAdapter(GroupListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GroupViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_group, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        presenter.onBindViewHolder(holder, position);
        holder.setOnClick(view -> presenter.onClickGroup(position));
    }

    @Override
    public int getItemCount() {
        return presenter.getGroupRowsCount();
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return presenter.getGroupId(position);
    }
}
