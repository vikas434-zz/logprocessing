package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.domain.NotificationType;
import com.halodoc.logprocessor.domain.User;

import java.util.List;

public interface NotificationService {

    public void sendNotification(User user, List<NotificationType> notificationType);

    public void sendNotification(User user);
}
