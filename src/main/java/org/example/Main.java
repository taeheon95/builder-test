package org.example;

import org.example.notification.Notification;
import org.example.notification.NotificationSender;
import org.example.notification.SmsNotificationSender;
import org.example.security.MyHttpSecurity;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Notification
                .builder("test@gmail.com", "test", "test")
                .notificationSender(NotificationSender.getInstance())
                .requestSuccessHandler(requestResult -> System.out.println("test request success"))
                .requestErrorHandler(requestResult -> System.out.println("test request error"))
                .send();
        Notification
                .builder("test@gmail.com", "test", "test")
                .notificationSender(new SmsNotificationSender())
                .send();
        Notification
                .builder("test@gmail.com", "test", "test")
                .send();
        Notification.Builder builder = Notification
                .builder("test@gmail.com", "test", "test")
                .notificationSender(NotificationSender.getInstance())
                .requestSuccessHandler(requestResult -> System.out.println("test request success"))
                .requestErrorHandler(requestResult -> System.out.println("test request error"));
        System.out.println("before send notification");
        builder.send();

        List.of(1,2,3,4)
                .stream()
                .map(i->i*2)
                .filter(i->i>2)
                .collect(Collectors.toList());
        CompletableFuture
                .runAsync(() -> {
                })
                .thenRunAsync(()->{
                })
                .join();
        MyHttpSecurity myHttpSecurity = new MyHttpSecurity();
        myHttpSecurity
                .myAuthorizeHttpRequests()
                .and()
                .myAuthorizeHttpRequests()
                .and()
                .myFormLogin()
                .and()
                .myRememberMe();
        myHttpSecurity.build();
    }
}