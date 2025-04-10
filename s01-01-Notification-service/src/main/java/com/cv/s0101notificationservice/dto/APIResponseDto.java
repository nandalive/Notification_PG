package com.cv.s0101notificationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 695962514098607683L;
    private boolean status;
    private String message;
    private Integer type;
    private Object object;

}
