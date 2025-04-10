package com.cv.s0101notificationservice.exception;

import java.io.Serial;

public class ApplicationException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6821617971477506666L;

    public ApplicationException(String message) {
        super(message);
    }

}
