package edu.groups.app.ui.main.group;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.groups.app.R;
import edu.groups.app.ui.BaseViewFragment;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListFragment extends BaseViewFragment<GroupListContract.Presenter>
        implements GroupListContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_group_list, container, false);
    }
}
