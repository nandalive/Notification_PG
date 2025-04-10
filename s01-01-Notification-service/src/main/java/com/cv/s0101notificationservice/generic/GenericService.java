package com.cv.s0101notificationservice.generic;

import java.util.Map;

public interface GenericService<T> {

    T create(T dto) throws Exception;

    T update(T dto) throws Exception;

    Boolean updateStatus(String id, boolean status) throws Exception;

    T readOne(String id) throws Exception;

    Boolean delete(String id) throws Exception;

    Map<String, String> readIdAndNameMap() throws Exception;

}
