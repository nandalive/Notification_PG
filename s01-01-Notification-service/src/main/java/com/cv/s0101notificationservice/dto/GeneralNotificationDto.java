package com.cv.s0101notificationservice.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class GeneralNotificationDto {

    private String notificationType;
    private String attachementStatus;
    private String deliveryStatus;
    private String deliveryStatusDescription;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime deliveryTime;
    private String subject;
    private String body;
    private String attachementPath;
    private List<RecipientDto> recipients;
}
