package org.example;

import java.util.List;

public class Notification {
    private final String recipient;
    private final String title;
    private final String content;

    private Notification(Builder builder) {
        this.recipient = builder.recipient;
        this.title = builder.title;
        this.content = builder.content;
    }

    public static Builder builder(String recipient, String title, String content) {
        return new Builder(recipient, title, content);
    }

    public static class Builder {
        private final String recipient;
        private final String title;
        private final String content;
        private int retry = 0;
        private NotificationSender notificationSender = NotificationSender.getInstance();
        private RequestSuccessHandler requestSuccessHandler;
        private RequestErrorHandler requestErrorHandler;

        public Builder(String recipient, String title, String content) {
            this.recipient = recipient;
            this.title = title;
            this.content = content;
        }

        public Builder retry(int retry) {
            this.retry = retry;
            return this;
        }

        public Builder requestSuccessHandler(RequestSuccessHandler successHandler) {
            this.requestSuccessHandler = successHandler;
            return this;
        }

        public Builder requestErrorHandler(RequestErrorHandler requestErrorHandler) {
            this.requestErrorHandler = requestErrorHandler;
            return this;
        }

        public Builder notificationSender(NotificationSender notificationSender) {
            this.notificationSender = notificationSender;
            return this;
        }

        public RequestResult send() {
            Notification notification = new Notification(this);
            try {
                RequestResult requestResult = notificationSender.sendNotification(notification);
                if (requestSuccessHandler != null) {
                    requestSuccessHandler.handleSuccess(requestResult);
                }
                return requestResult;
            } catch (Exception e) {
                RequestResult failRequestResult = new RequestResult();
                if (requestErrorHandler != null) {
                    requestErrorHandler.handleError(failRequestResult);
                }
                return failRequestResult;
            }
        }
    }
}
