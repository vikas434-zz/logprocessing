package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.domain.LogEvent;
import com.halodoc.logprocessor.domain.NotificationSentStatus;
import com.halodoc.logprocessor.domain.User;

import java.util.concurrent.atomic.AtomicInteger;

public class UserEventProcessingServiceImpl implements UserEventProcessingService {

    private static final AtomicInteger RESET = new AtomicInteger();

    @Override
    public boolean isRequiredToSendNotification(User user, LogEvent logEvent) {
        // Check current count of the log.
        AtomicInteger currentLogCount = user.getCurrentLogCount();
        if (currentLogCount.get() == (user.getFrequency() - 1)) {
            currentLogCount.getAndIncrement();
            user.setCurrentLogCount(currentLogCount);
            user.setLastTimeStamp(System.currentTimeMillis());
            user.setNotificationSentStatus(NotificationSentStatus.SENT);
            return true;
        } else if (currentLogCount.get() == user.getFrequency()) {
            // Check time stamp, if more than threshold then reset count.
            if (logEvent.getCurrentTimeStamp() - user.getLastTimeStamp() > user.getWaitTime()) {
                user.setCurrentLogCount(RESET);
                user.setNotificationSentStatus(NotificationSentStatus.RESET);
                user.setLastTimeStamp(System.currentTimeMillis());
            } else {
                user.setNotificationSentStatus(NotificationSentStatus.WAITING);
                System.out.println("Still in waiting state");
            }
        } else {
            user.setCurrentLogCount(new AtomicInteger(currentLogCount.getAndIncrement()));
            user.setLastTimeStamp(System.currentTimeMillis());
        }
        return false;
    }
}
