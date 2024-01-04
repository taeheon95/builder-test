package org.example;

public class SmsNotificationSender implements NotificationSender {
    @Override
    public RequestResult sendNotification(Notification notification) {
        System.out.println("send sms noti");
        return new RequestResult();
    }
}
