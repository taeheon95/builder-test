package org.example.notification;

import org.example.common.RequestResult;

public abstract class NotificationSender {
    protected static NotificationSender instance;

    protected NotificationSender() {
    }

    public abstract RequestResult sendNotification(Notification notification);

    public static NotificationSender getInstance() {
        if (instance == null) {
            instance = new MailNotificationSender();
        }
        return instance;
    }
}
