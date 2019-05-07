package com.halodoc.logprocessor.event;

import com.halodoc.logprocessor.domain.LogEvent;
import com.halodoc.logprocessor.domain.LogType;
import com.halodoc.logprocessor.domain.User;
import com.halodoc.logprocessor.service.NotificationService;
import com.halodoc.logprocessor.service.UserEventProcessingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserEventListener implements LogEventListener {

    private User user;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserEventProcessingService userEventProcessingService;

    public UserEventListener(User user) {
        this.user = user;
    }

    @Override
    public void catchLogEvent(LogEvent logEvent) {
        // Process logs of that type only for which user is registered.
        if (isLogTypeOfUserInterest(logEvent, user)) {
            if (this.userEventProcessingService.isRequiredToSendNotification(user, logEvent)) {
                this.notificationService.sendNotification(user);
            }
        }

    }

    private boolean isLogTypeOfUserInterest(LogEvent logEvent, User user) {
        Optional<LogType> result = user.getLogTypes().stream().parallel().filter(logType -> logEvent.getLogType() == logType).findAny();
        return result.isPresent();
    }
}
