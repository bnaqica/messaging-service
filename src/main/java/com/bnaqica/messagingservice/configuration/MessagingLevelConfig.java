package com.bnaqica.messagingservice.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessagingLevelConfig {
    private List<MessagingOperation> steps;
}
