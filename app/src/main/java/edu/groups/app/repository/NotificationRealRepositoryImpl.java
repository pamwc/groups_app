package edu.groups.app.repository;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.UUID;

import edu.groups.app.model.Notification;
import io.realm.Realm;

/**
 * Created by Piotr Borczyk on 26.11.2017.
 */

public class NotificationRealRepositoryImpl implements NotificationRealmRepository {

    private Realm realm;

    public NotificationRealRepositoryImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void saveAsync(Notification notification, Realm.Transaction.OnSuccess onSuccess) {
        UUID uuid = UUID.randomUUID();
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        notification.setUuid(byteBuffer.array());
        realm.executeTransactionAsync(realm1 -> realm1.insert(notification), onSuccess);
    }

    @Override
    public void removeAsync(Notification notification, Realm.Transaction.OnSuccess onSuccess) {
        realm.executeTransactionAsync(realm1 -> realm1.where(Notification.class).equalTo("uuid", notification.getUuid())
                .findAll().deleteAllFromRealm());
    }

    @Override
    public void removeAll(Realm.Transaction.OnSuccess onSuccess) {
        realm.executeTransactionAsync(realm1 -> realm1.delete(Notification.class), onSuccess);
    }

    @Override
    public void dispose() {
        realm.close();
    }

    @Override
    public boolean isDisposed() {
        return realm.isClosed();
    }

}
