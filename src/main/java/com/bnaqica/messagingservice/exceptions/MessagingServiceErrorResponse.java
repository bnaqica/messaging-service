package com.bnaqica.messagingservice.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class MessagingServiceErrorResponse {
    private LocalDateTime date;
    private int status;
    private String message;

    public MessagingServiceErrorResponse(int status, Exception e) {
        this.date = LocalDateTime.now();
        this.status = status;
        this.message = e.getMessage();
    }
}
