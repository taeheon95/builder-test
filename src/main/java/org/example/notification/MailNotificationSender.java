package org.example.notification;

import org.example.common.RequestResult;

public class MailNotificationSender extends NotificationSender {
    @Override
    public RequestResult sendNotification(Notification notification) {
        System.out.println("send mail noti");
        return new RequestResult();
    }
}
