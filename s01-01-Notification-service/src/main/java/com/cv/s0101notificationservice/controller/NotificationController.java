package com.cv.s0101notificationservice.controller;

import com.cv.s0101notificationservice.constant.UAMConstant;
import com.cv.s0101notificationservice.service.intrface.GeneralNotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UAMConstant.APP_NAVIGATION_API_NOTIFICATION)
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private GeneralNotificationService service;
/*
    @PostMapping(ApplicationConstant.APPLICATION_GENERAL_NOTIFICATION_EMAIL)
    public ResponseEntity<Object> sendNotification(@RequestBody @Valid EmailNotificationDto dto, BindingResult result) {
        try {
            return StaticUtil.getSuccessResponse(service.sendEmailNotification(dto), APIResponseType.OBJECT_ONE);
        } catch (Exception e) {
            log.error("General.Notification {}", ExceptionUtils.getStackTrace(e));
            return StaticUtil.getFailureResponse(e);
        }
    }
*/

}
