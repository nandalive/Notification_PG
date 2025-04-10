package com.cv.s0101notificationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RecipientEntity {

    @Version
    private Long version; // Add this version field
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String SenderName;
    private String notificationId;
    private LocalDateTime deliveryTime;
    private String status;
    private String errorMessage;
    @ManyToOne
    @JoinColumn(name = "General_notification_id")
    private GeneralNotification generalNotification;
}
