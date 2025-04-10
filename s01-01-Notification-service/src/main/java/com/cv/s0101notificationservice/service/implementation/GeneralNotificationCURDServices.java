package com.cv.s0101notificationservice.service.implementation;

import com.cv.s0101notificationservice.dto.EmailNotificationResponseDto;
import com.cv.s0101notificationservice.dto.GeneralNotificationDto;
import com.cv.s0101notificationservice.entity.GeneralNotification;
import com.cv.s0101notificationservice.mapper.NotificationMapper;
import com.cv.s0101notificationservice.repository.GeneralNotificationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)

public class GeneralNotificationCURDServices {

    EmailNotificationResponseDto emailNotificationResponseDtol;
    private JavaMailSender mailSender;
    private final GeneralNotificationRepository repository;
    private final NotificationMapper mapper;
    @PersistenceContext
    private EntityManager entityManager;

    public GeneralNotificationDto insertEmailNotification(GeneralNotificationDto dto) throws Exception {

        try {
            GeneralNotification entity = mapper.toEntity(dto);

            // Ensure recipients are attached to the persistence context
            if (entity.getRecipients() != null) {
                entity.getRecipients().forEach(recipient -> {
                    if (recipient.getId() != null) {
                        // If the recipient is already saved, merge it
                        recipient = entityManager.merge(recipient);  // entityManager is injected
                    } else {
                        // If the recipient is a new one, persist it
                        entityManager.persist(recipient);
                    }

                    recipient.setGeneralNotification(entity);  // Ensure the bidirectional relationship is set
                });

            }

            GeneralNotification savedEntity = repository.save(entity);

            return mapper.toDto(savedEntity);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error while inserting email notification", ex);
        }


    }


}
