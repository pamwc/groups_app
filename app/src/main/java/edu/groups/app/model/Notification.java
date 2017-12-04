package edu.groups.app.model;

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
public class Notification {
    private String title;
    private NotificationType notificationType;
    private String content;
    private Long groupId;
    private Long postId;
    private Long commentId;
    private String author;
}
