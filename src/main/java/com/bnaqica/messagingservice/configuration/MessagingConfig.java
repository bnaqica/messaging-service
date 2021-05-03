package com.bnaqica.messagingservice.configuration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("messaging.config")
public class MessagingConfig implements Serializable {
    private Map<String, MessagingLevelConfig> messagingLevelConfigMap;
}
