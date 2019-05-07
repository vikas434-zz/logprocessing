package com.halodoc.logprocessor.service;

import com.halodoc.logprocessor.domain.NotificationType;
import com.halodoc.logprocessor.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    @Override
    public void sendNotification(User user, List<NotificationType> notificationType) {

    }
}
