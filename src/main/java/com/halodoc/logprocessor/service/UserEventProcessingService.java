package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.domain.LogEvent;
import com.halodoc.logprocessor.domain.User;

public interface UserEventProcessingService {
    boolean isRequiredToSendNotification(User user, LogEvent logEvent);
}
