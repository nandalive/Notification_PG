package com.cv.s0101notificationservice.exception;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExceptionComponent {
    private final Environment environment;

    public ApplicationException expose(String message, Boolean isProperty) {
        if (isProperty) {
            message = environment.getProperty(message);
        }
        return new ApplicationException(message);
    }
}
