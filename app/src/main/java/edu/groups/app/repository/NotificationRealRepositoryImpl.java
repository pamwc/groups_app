package edu.groups.app.repository;

import java.nio.ByteBuffer;
import java.util.UUID;

import edu.groups.app.model.NotificationDto;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Piotr Borczyk on 26.11.2017.
 */

public class NotificationRealRepositoryImpl implements NotificationRealmRepository {

    private Realm realm;

    public NotificationRealRepositoryImpl(Realm realm) {
        this.realm = realm;
    }

    @Override
    public void saveAsync(NotificationDto notification, Realm.Transaction.OnSuccess onSuccess) {
        UUID uuid = UUID.randomUUID();
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        notification.setUuid(byteBuffer.array());
        realm.executeTransactionAsync(realm1 -> realm1.insert(notification), onSuccess);
    }

    @Override
    public void removeAsync(NotificationDto notification, Realm.Transaction.OnSuccess onSuccess) {
        realm.executeTransactionAsync(realm1 -> realm1.where(NotificationDto.class).equalTo("uuid", notification.getUuid())
                .findAll().deleteAllFromRealm());
    }

    @Override
    public io.reactivex.Flowable<RealmResults<NotificationDto>> getAll() {
        return realm.where(NotificationDto.class).findAllAsync().asFlowable().filter(RealmResults::isLoaded);
    }

    @Override
    public void removeAll(Realm.Transaction.OnSuccess onSuccess) {
        realm.executeTransactionAsync(realm1 -> realm1.delete(NotificationDto.class), onSuccess);
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
