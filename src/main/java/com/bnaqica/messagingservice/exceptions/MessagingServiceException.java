package com.bnaqica.messagingservice.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessagingServiceException extends RuntimeException {
    public MessagingServiceException(String message) {
        super(message);
    }
}
