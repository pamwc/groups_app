package edu.groups.app.ui.main.group.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;

/**
 * Created by Kamil on 20/11/2017.
 */

public class GroupViewHolder extends RecyclerView.ViewHolder implements GroupRowView {

    @BindView(R.id.group_name) TextView name;

    public GroupViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setName(String name) {
        this.name.setText(name);
    }
}
