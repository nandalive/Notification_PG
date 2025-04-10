package com.cv.s0101notificationservice.dto;

import com.cv.s0101notificationservice.entity.GeneralNotification;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class RecipientDto {

    private Long id;
    private String email;
    private String SenderName;
    private String notificationId;
    private LocalDateTime deliveryTime;
    private String status;
    private String errorMessage;
    private GeneralNotification generalNotification;
}
