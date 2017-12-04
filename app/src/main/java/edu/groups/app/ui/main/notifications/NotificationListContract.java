package edu.groups.app.ui.main.notifications;

import android.support.v7.widget.RecyclerView;

import edu.groups.app.model.Notification;
import edu.groups.app.model.NotificationDto;
import edu.groups.app.ui.MvpContract;

/**
 * Created by Piotr Borczyk on 27.11.2017.
 */

public interface NotificationListContract {

    interface View extends MvpContract.View {
        void setAdapter(RecyclerView.Adapter adapter);
        void notifyDataSetChanged();
    }

    interface Presenter extends MvpContract.Presenter {
        int getNotificationCount();
        NotificationDto getNotification(int position);
    }

}
