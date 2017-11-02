package edu.groups.app.firebase;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import edu.groups.app.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Dawid Świnoga on 01.11.2017.
 */

public class FirebaseNotificationMessagingService extends FirebaseMessagingService {
    public FirebaseNotificationMessagingService() {

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        sendNotification(remoteMessage.getData());
        Log.d(TAG, "Message data payload: " + remoteMessage.getData());
    }

    public void sendNotification(Map<String, String> data) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("My notification")
                        .setContentText(data.toString());

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(001, mBuilder.build());
    }
}
