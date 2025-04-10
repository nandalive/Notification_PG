package com.cv.s0101notificationservice.service.implementation;

import com.cv.s0101notificationservice.dto.GeneralNotificationDto;
import com.cv.s0101notificationservice.service.intrface.KafkaListenerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Getter
@Setter
public class KafkaNotificationConsumerServices implements KafkaListenerService {

     GeneralNotificationServiceImplementation NotificationServiceImpl;
/*
    @KafkaListener(topics = "email-notifications", groupId = "notification-group")
    public void listenerReadQueue(EmailNotificationDto dto) {
        try {
            //NotificationServiceImpl.sendEmailNotification(dto);
            System.out.println("Received Message: " + dto.getBody());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
*/

    @KafkaListener(topics = "email-notifications", groupId = "notification-group")
    @Override
    public void listenerReadQueueGeneral(GeneralNotificationDto dto) {
        try {
            NotificationServiceImpl.handleGeneralNotification(dto);
            System.out.println("Received Message: " + dto.getBody());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
