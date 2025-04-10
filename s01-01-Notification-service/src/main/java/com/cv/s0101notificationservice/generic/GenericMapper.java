package com.cv.s0101notificationservice.generic;

public interface GenericMapper<T, T1> {

    T toDto(T1 entity);

    T1 toEntity(T dto);

}
