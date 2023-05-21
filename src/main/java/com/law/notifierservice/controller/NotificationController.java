package com.law.notifierservice.controller;

import com.law.notifierservice.model.dto.RequestNotificationDTO;
import com.law.notifierservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class NotificationController {

    @Autowired
    private NotificationService notifierService;

    @PostMapping(value = "/send-notification")
    public ResponseEntity<Object> sendMessage(@RequestBody RequestNotificationDTO notification) {
        notifierService.processNotification(notification);
        return ResponseEntity.ok("Notification kepada " + notification.getUsername() + " terkirim");
    }

    @GetMapping("/notification/{username}")
    public ResponseEntity<Object> getAllNotificationByUsername(@PathVariable String username) {
        return ResponseEntity.ok(notifierService.getAllNotificationsByUsername(username));
    }
}
