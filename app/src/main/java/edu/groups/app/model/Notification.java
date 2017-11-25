package edu.groups.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Dawid Świnoga on 25.11.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    private String title;
    private NotificationType notificationType;
    private String content;
    private Long groupId;
    private Long postId;
    private Long commentId;
}
