package edu.groups.app.ui.main.notifications;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.ui.BaseViewFragment;

public class NotificationListFragment extends BaseViewFragment<NotificationListContract.Presenter> implements NotificationListContract.View {
    @BindView(R.id.notification_list)
    RecyclerView notficationList;

    public NotificationListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification_list, container, false);
        ButterKnife.bind(this, view);
        notficationList.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void setAdapter(RecyclerView.Adapter adapter) {
        notficationList.setAdapter(adapter);
    }

    @Override
    public void notifyDataSetChanged() {
        notficationList.getAdapter().notifyDataSetChanged();
    }

}
