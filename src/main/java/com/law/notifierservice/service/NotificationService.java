package com.law.notifierservice.service;

import com.law.notifierservice.model.Notification;
import com.law.notifierservice.model.dto.RequestNotificationDTO;

import java.util.List;

public interface NotificationService {
    void processNotification(RequestNotificationDTO message);

    List<Notification> getAllNotificationsByUsername(String username);
}
