package com.bnaqica.messagingservice.configuration;

import com.bnaqica.messagingservice.enums.OperationName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessagingOperation {
    private OperationName operationName;
    private List<Map<String, String>> addRequestField;
    private String outputName;
    private String cacheKey;
}
