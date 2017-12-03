package edu.groups.app.repository;


import edu.groups.app.model.Notification;
import edu.groups.app.model.NotificationDto;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.realm.RealmResults;

import static io.realm.Realm.Transaction.OnSuccess;

/**
 * Created by Piotr Borczyk on 26.11.2017.
 */

public interface NotificationRealmRepository extends Disposable {
    void saveAsync(NotificationDto notification, OnSuccess onSuccess);
    void removeAsync(NotificationDto notification, OnSuccess onSuccess);
    Flowable<RealmResults<NotificationDto>> getAll();
    void removeAll(OnSuccess onSuccess);
}
