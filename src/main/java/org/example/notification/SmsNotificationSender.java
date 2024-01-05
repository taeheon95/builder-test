package org.example.notification;

import org.example.common.RequestResult;

public class SmsNotificationSender extends NotificationSender {

    @Override
    public RequestResult sendNotification(Notification notification) {
        System.out.println("send sms noti");
        return new RequestResult();
    }
}
