package edu.groups.app.model;

import java.nio.ByteBuffer;
import java.util.UUID;

import io.realm.RealmObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by Dawid Świnoga on 25.11.2017.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto extends RealmObject {
    private String title;
    private String notificationTypeValue;
    private String content;
    private Long groupId;
    private Long postId;
    private Long commentId;
    private byte[] uuid;

    public NotificationType getNotificationType() {
        return NotificationType.valueOf(notificationTypeValue);
    }

    public void setNotificationType(NotificationType notificationType) {
        notificationTypeValue = notificationType.name();
    }

    public static NotificationDto getDto(Notification notification) {
        NotificationDto dto = new NotificationDto();
        dto.setCommentId(notification.getCommentId());
        dto.setContent(notification.getContent());
        dto.setGroupId(notification.getGroupId());
        dto.setNotificationType(notification.getNotificationType());
        dto.setTitle(notification.getTitle());
        dto.setPostId(notification.getPostId());
        dto.setUuid(prepareUUID());
        return dto;
    }

    private static byte[] prepareUUID() {
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        UUID uuid = UUID.randomUUID();
        byteBuffer.putLong(uuid.getMostSignificantBits());
        byteBuffer.putLong(uuid.getLeastSignificantBits());
        return byteBuffer.array();
    }
}
