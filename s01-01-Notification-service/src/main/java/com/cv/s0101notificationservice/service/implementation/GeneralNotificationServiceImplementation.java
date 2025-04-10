package com.cv.s0101notificationservice.service.implementation;


import com.cv.s0101notificationservice.dto.EmailNotificationResponseDto;
import com.cv.s0101notificationservice.dto.GeneralNotificationDto;
import com.cv.s0101notificationservice.dto.RecipientDto;
import com.cv.s0101notificationservice.mapper.NotificationMapper;
import com.cv.s0101notificationservice.repository.GeneralNotificationRepository;
import com.cv.s0101notificationservice.service.intrface.GeneralNotificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Service
@AllArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class GeneralNotificationServiceImplementation implements GeneralNotificationService {

    EmailNotificationResponseDto emailNotificationResponseDtol;
    private JavaMailSender mailSender;
    private final GeneralNotificationRepository repository;
    private final NotificationMapper mapper;
    private GeneralNotificationCURDServices generalNotificationCURDServices;
/*
    @Override
    public EmailNotificationResponseDto sendEmailNotification(EmailNotificationDto emailNotificationDto) {
        System.out.println("Service layer execution");
        try {
            EmailNotificationDto resDTO = insertEmailNotification(emailNotificationDto);
            System.out.println("Name:" + resDTO.getToName());
            if (!resDTO.getToName().isEmpty()) {
                sendEmail(emailNotificationDto.getToEmail(), emailNotificationDto.getSubject(), emailNotificationDto.getToName(), emailNotificationDto.getBody());

            } else {
                System.out.println("Not Inserted");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return emailNotificationResponseDtol;
    }
*/

    public void sendEmail(String to, String subject, String userName, String message) throws MessagingException {
        String attachmentPath = "D:\\\\Sample.pdf";
        // Initialize Velocity
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "class");
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        velocityEngine.init();
        Template template = velocityEngine.getTemplate("/templates/email-template.vm", "UTF-8");
        VelocityContext context = new VelocityContext();
        context.put("title", subject);
        context.put("header", "Notification Alert");
        context.put("userName", userName);
        context.put("message", message);
        context.put("Subject", subject);
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println("Final Email=>" + writer.toString());
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, StandardCharsets.UTF_8.name());

        if (attachmentPath != null && !attachmentPath.isEmpty()) {
            File file = new File(attachmentPath);
            if (file.exists()) {
                FileSystemResource resource = new FileSystemResource(file);
                helper.addAttachment(file.getName(), resource);
            } else {
                System.out.println("Attachment file not found: " + attachmentPath);
            }
        }
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(writer.toString(), true);
        mailSender.send(mimeMessage);
    }

    /*
        public EmailNotificationDto insertEmailNotification(EmailNotificationDto dto) throws Exception {
            EmailNotification entity = mapper.toEntity(dto);
            System.out.println("Saving Entity: " + entity);

            return mapper.toDto(repository.save(mapper.toEntity(dto)));
        }
    */
    public void handleGeneralNotification(GeneralNotificationDto Dto) {
        try {

            //GeneralNotificationDto generalNotificationDto = generalNotificationCURDServices.insertEmailNotification(Dto);

            if (Dto.getNotificationType().equalsIgnoreCase("S")) {
                RecipientDto recipientDto = Dto.getRecipients().getFirst();
                sendEmail(recipientDto.getEmail(), Dto.getSubject(), recipientDto.getSenderName(), Dto.getBody());
            } else {
                //Bulk Email Notificatio
            }
        } catch (Exception ex) {

        }
    }

}
