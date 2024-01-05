package org.example.notification;

import org.example.common.RequestResult;

import java.util.Optional;

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
        private Optional<NotificationSender> notificationSender = Optional.ofNullable(null);
        private Optional<RequestSuccessHandler> requestSuccessHandler = Optional.ofNullable(null);
        private Optional<RequestErrorHandler> requestErrorHandler = Optional.ofNullable(null);

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
            this.requestSuccessHandler = Optional.ofNullable(successHandler);
            return this;
        }

        public Builder requestErrorHandler(RequestErrorHandler requestErrorHandler) {
            this.requestErrorHandler = Optional.ofNullable(requestErrorHandler);
            return this;
        }

        public Builder notificationSender(NotificationSender notificationSender) {
            this.notificationSender = Optional.ofNullable(notificationSender);
            return this;
        }

        public RequestResult send() {
            Notification notification = new Notification(this);
            try {
                RequestResult requestResult = notificationSender
                        .orElseGet(NotificationSender::getInstance)
                        .sendNotification(notification);
                requestSuccessHandler
                        .ifPresent(successHandler -> successHandler.handleSuccess(requestResult));
                return requestResult;
            } catch (Exception e) {
                RequestResult failRequestResult = new RequestResult();
                requestErrorHandler
                        .ifPresent(errorHandler->errorHandler.handleError(failRequestResult));
                return failRequestResult;
            }
        }
    }
}
