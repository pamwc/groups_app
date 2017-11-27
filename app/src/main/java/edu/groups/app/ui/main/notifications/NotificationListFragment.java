package edu.groups.app.ui.main.notifications;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.groups.app.R;
import edu.groups.app.ui.BaseViewFragment;
import edu.groups.app.ui.main.notifications.dummy.DummyContent;
import edu.groups.app.ui.main.notifications.dummy.DummyContent.DummyItem;

import java.util.List;


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
        notficationList.setAdapter(new NotificationAdapter(DummyContent.ITEMS));
        return view;
    }
}
