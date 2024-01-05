package org.example.notification;

import org.example.common.RequestResult;

public interface RequestSuccessHandler {
    void handleSuccess(RequestResult requestResult);
}
