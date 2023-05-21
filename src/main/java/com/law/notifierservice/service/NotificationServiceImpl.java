package com.law.notifierservice.service;

import com.law.notifierservice.model.Notification;
import com.law.notifierservice.model.StatusNotification;
import com.law.notifierservice.model.dto.RequestNotificationDTO;
import com.law.notifierservice.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public void processNotification(RequestNotificationDTO message) {
        simpMessagingTemplate.convertAndSendToUser(message.getUsername(),"/notification", message);
        saveNotification(message);
    }

    @Override
    public List<Notification> getAllNotificationsByUsername(String username) {
        return notificationRepository.findAllByUsernameOrderByDateAsc(username);
    }

    private void saveNotification(RequestNotificationDTO requestNotification) {
        Notification notification = new Notification();
        notification.setUsername(requestNotification.getUsername());
        notification.setMessage(requestNotification.getMessage());
        notification.setStatus(StatusNotification.valueOf(requestNotification.getStatus()));
        notificationRepository.save(notification);
    }
}
