package com.law.notifierservice.model.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RequestNotificationDTO {
    private String username;
    private String message;
    private LocalDateTime date;
    private String status;

    public RequestNotificationDTO(String username, String message, String status) {
        this.username = username;
        this.message = message;
        this.date = LocalDateTime.now();
        this.status = status;
    }
}

