package com.law.notifierservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Table(name="notification")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Notification {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column (name = "message", nullable = false)
    private String message;

    @NotNull
    @Column (name = "date", nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    @NotNull
    @Column (name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusNotification status;

}