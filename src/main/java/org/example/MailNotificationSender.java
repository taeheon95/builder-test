package org.example;

public class MailNotificationSender implements NotificationSender {
    @Override
    public RequestResult sendNotification(Notification notification) {
        System.out.println("send mail noti");
        return new RequestResult();
    }
}
