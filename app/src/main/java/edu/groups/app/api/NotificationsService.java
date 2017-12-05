package edu.groups.app.api;

import java.util.List;

import edu.groups.app.model.NotificationDto;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Piotr Borczyk on 04.12.2017.
 */

public interface NotificationsService {
    @GET("notifications/my")
    Observable<List<NotificationDto>> getNotifications();
}
