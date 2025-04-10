package com.cv.s0101notificationservice.mapper;

import com.cv.s0101notificationservice.dto.GeneralNotificationDto;
import com.cv.s0101notificationservice.dto.RecipientDto;
import com.cv.s0101notificationservice.entity.GeneralNotification;
import com.cv.s0101notificationservice.entity.RecipientEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-06T17:15:10+0400",
    comments = "version: 1.6.2, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class NotificationMapperImpl implements NotificationMapper {

    @Override
    public GeneralNotificationDto toDto(GeneralNotification entity) {
        if ( entity == null ) {
            return null;
        }

        GeneralNotificationDto.GeneralNotificationDtoBuilder<?, ?> generalNotificationDto = GeneralNotificationDto.builder();

        generalNotificationDto.notificationType( entity.getNotificationType() );
        generalNotificationDto.attachementStatus( entity.getAttachementStatus() );
        generalNotificationDto.createdAt( entity.getCreatedAt() );
        generalNotificationDto.createdBy( entity.getCreatedBy() );
        generalNotificationDto.subject( entity.getSubject() );
        generalNotificationDto.body( entity.getBody() );
        generalNotificationDto.attachementPath( entity.getAttachementPath() );
        generalNotificationDto.recipients( toRecipientDtoList( entity.getRecipients() ) );

        return generalNotificationDto.build();
    }

    @Override
    public GeneralNotification toEntity(GeneralNotificationDto dto) {
        if ( dto == null ) {
            return null;
        }

        GeneralNotification generalNotification = new GeneralNotification();

        generalNotification.setNotificationType( dto.getNotificationType() );
        generalNotification.setCreatedAt( dto.getCreatedAt() );
        generalNotification.setCreatedBy( dto.getCreatedBy() );
        generalNotification.setSubject( dto.getSubject() );
        generalNotification.setBody( dto.getBody() );
        generalNotification.setAttachementStatus( dto.getAttachementStatus() );
        generalNotification.setAttachementPath( dto.getAttachementPath() );
        generalNotification.setRecipients( toRecipientEntityList( dto.getRecipients() ) );

        return generalNotification;
    }

    @Override
    public RecipientDto toDto(RecipientEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RecipientDto recipientDto = new RecipientDto();

        recipientDto.setId( entity.getId() );
        recipientDto.setEmail( entity.getEmail() );
        recipientDto.setSenderName( entity.getSenderName() );
        recipientDto.setNotificationId( entity.getNotificationId() );
        recipientDto.setDeliveryTime( entity.getDeliveryTime() );
        recipientDto.setStatus( entity.getStatus() );
        recipientDto.setErrorMessage( entity.getErrorMessage() );
        recipientDto.setGeneralNotification( entity.getGeneralNotification() );

        return recipientDto;
    }

    @Override
    public RecipientEntity toEntity(RecipientDto dto) {
        if ( dto == null ) {
            return null;
        }

        RecipientEntity recipientEntity = new RecipientEntity();

        recipientEntity.setId( dto.getId() );
        recipientEntity.setEmail( dto.getEmail() );
        recipientEntity.setSenderName( dto.getSenderName() );
        recipientEntity.setNotificationId( dto.getNotificationId() );
        recipientEntity.setDeliveryTime( dto.getDeliveryTime() );
        recipientEntity.setStatus( dto.getStatus() );
        recipientEntity.setErrorMessage( dto.getErrorMessage() );

        return recipientEntity;
    }

    @Override
    public List<RecipientDto> toRecipientDtoList(List<RecipientEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<RecipientDto> list = new ArrayList<RecipientDto>( entities.size() );
        for ( RecipientEntity recipientEntity : entities ) {
            list.add( toDto( recipientEntity ) );
        }

        return list;
    }

    @Override
    public List<RecipientEntity> toRecipientEntityList(List<RecipientDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<RecipientEntity> list = new ArrayList<RecipientEntity>( dtos.size() );
        for ( RecipientDto recipientDto : dtos ) {
            list.add( toEntity( recipientDto ) );
        }

        return list;
    }
}
