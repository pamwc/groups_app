package edu.groups.app.ui.main.group;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.navigation.Navigator;
import edu.groups.app.ui.BaseViewFragment;

/**
 * Created by Kamil on 10/11/2017.
 */

public class GroupListFragment extends BaseViewFragment<GroupListContract.Presenter>
        implements GroupListContract.View {

    @BindView(R.id.textView) TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);
        ButterKnife.bind(this, view);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigator.openGroupActivity(getActivity(), 2L);
            }
        });
        return view;
    }

    @Override
    public void showMessage(String message) {
        textView.setText(message);
    }
}
