package edu.groups.app.repository;

import java.util.List;

import edu.groups.app.model.Notification;
import io.reactivex.disposables.Disposable;
import io.realm.Realm;

import static io.realm.Realm.Transaction.OnSuccess;

/**
 * Created by Piotr Borczyk on 26.11.2017.
 */

public interface NotificationRealmRepository extends Disposable {
    void saveAsync(Notification notification, OnSuccess onSuccess);
    void removeAsync(Notification notification, OnSuccess onSuccess);

    void removeAll(OnSuccess onSuccess);
}
