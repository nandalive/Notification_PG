package com.cv.s0101notificationservice.service.intrface;

import com.cv.s0101notificationservice.dto.GeneralNotificationDto;

public interface KafkaListenerService {


    //public void listenerReadQueue(EmailNotificationDto emailNotificationDto);
    public void listenerReadQueueGeneral(GeneralNotificationDto generalNotificationDto);

}
