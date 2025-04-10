package com.cv.s0101notificationservice.mapper;

import com.cv.s0101notificationservice.dto.GeneralNotificationDto;
import com.cv.s0101notificationservice.dto.RecipientDto;
import com.cv.s0101notificationservice.entity.GeneralNotification;
import com.cv.s0101notificationservice.entity.RecipientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMapper {

    // Notification Mapping
    GeneralNotificationDto toDto(GeneralNotification entity);
    GeneralNotification toEntity(GeneralNotificationDto dto);

    // Recipient Mapping
    RecipientDto toDto(RecipientEntity entity);
    @Mapping(target = "generalNotification", ignore = true) // We'll set this manually in service
    RecipientEntity toEntity(RecipientDto dto);

    // List Mappings (optional if needed manually)
    List<RecipientDto> toRecipientDtoList(List<RecipientEntity> entities);
    List<RecipientEntity> toRecipientEntityList(List<RecipientDto> dtos);



}
