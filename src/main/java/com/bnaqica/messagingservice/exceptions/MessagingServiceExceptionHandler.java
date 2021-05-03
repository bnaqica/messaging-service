package com.bnaqica.messagingservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class MessagingServiceExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({Exception.class})
    public MessagingServiceErrorResponse handleException(Exception ex) {
        return getErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private MessagingServiceErrorResponse getErrorResponse(Exception ex, HttpStatus status) {
        log.error(ex.getMessage(), ex);
        return new MessagingServiceErrorResponse(status.value(), ex);
    }
}
