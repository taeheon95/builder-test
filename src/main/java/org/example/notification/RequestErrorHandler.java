package org.example.notification;

import org.example.common.RequestResult;

public interface RequestErrorHandler {
    void handleError(RequestResult requestResult);
}
