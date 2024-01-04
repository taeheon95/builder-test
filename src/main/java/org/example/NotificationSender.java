package org.example;

public interface NotificationSender {
    NotificationSender instance = new MailNotificationSender();
    RequestResult sendNotification(Notification notification);

    static NotificationSender getInstance() {
        return instance;
    }
}
