package com.bnaqica.messagingservice.controller;

import com.bnaqica.messagingservice.service.MessagingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
class MessagingController {

    private MessagingService messagingService;

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(value = "/messaging", produces = MediaType.APPLICATION_JSON_VALUE)
    public void processMessaging(@RequestBody Map<String, String> requestMap) {

        messagingService.processMessagingRequest(requestMap);
    }
}
