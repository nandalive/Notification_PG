package com.cv.s0101notificationservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GeneralNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String notificationType;
    private LocalDateTime createdAt;
    private String createdBy;
    private String subject;
    private String body;
    private String attachementStatus;
    private String attachementPath;
    @OneToMany(mappedBy = "generalNotification", cascade = CascadeType.ALL)
    private List<RecipientEntity> recipients;


}
