package edu.groups.app.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import java.util.concurrent.atomic.AtomicInteger;

import edu.groups.app.R;
import edu.groups.app.model.Notification;
import edu.groups.app.model.NotificationType;
import edu.groups.app.ui.group.GroupActivity;

import static android.app.Notification.DEFAULT_SOUND;
import static android.app.Notification.DEFAULT_VIBRATE;
import static android.app.PendingIntent.getActivity;
import static android.content.ContentValues.TAG;
import static edu.groups.app.ui.group.GroupActivity.COMMENT_ID;
import static edu.groups.app.ui.group.GroupActivity.GROUP_ID;
import static edu.groups.app.ui.group.GroupActivity.POST_ID;

/**
 * Created by Dawid Świnoga on 01.11.2017.
 */

public class FirebaseNotificationMessagingService extends FirebaseMessagingService {
    private Gson gson;
    private final static AtomicInteger c = new AtomicInteger(0);

    public FirebaseNotificationMessagingService() {
        this.gson = new Gson();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Notification notification = gson.fromJson(remoteMessage.getData().toString(), Notification.class);
        sendNotification(notification);
        saveNotification(notification);
        Log.d(TAG, "Notification data payload: " + notification);
    }

    private void saveNotification(Notification notification) {

    }

    public void sendNotification(Notification notification) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setTicker("notification")
                        .setDefaults(DEFAULT_SOUND | DEFAULT_VIBRATE)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle(getString(R.string.group) + ": " + notification.getTitle())
                        .setContentText(getLabel(notification.getNotificationType()) + ": " +
                                notification.getContent())
                        .setContentIntent(getIntent(notification))
                        .setAutoCancel(true);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(c.get(), mBuilder.build());
    }

    private PendingIntent getIntent(Notification notification) {
        final Intent intent = new Intent(getApplicationContext(), GroupActivity.class);
        intent.putExtra(GROUP_ID, notification.getGroupId());
        intent.putExtra(POST_ID, notification.getPostId());
        intent.putExtra(COMMENT_ID, notification.getCommentId());
        return getActivity(getApplicationContext(), getNextId(), intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private CharSequence getLabel(NotificationType notificationType) {
        if (notificationType == NotificationType.COMMENT) {
            return getString(R.string.comment);
        }
        if(notificationType == NotificationType.POST) {
            return getString(R.string.post);
        }

        return "";
    }

    public static int getNextId() {
        return c.incrementAndGet();
    }
}
