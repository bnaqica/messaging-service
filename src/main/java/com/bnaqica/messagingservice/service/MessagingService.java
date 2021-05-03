package com.bnaqica.messagingservice.service;

import com.bnaqica.messagingservice.configuration.MessagingConfig;
import com.bnaqica.messagingservice.configuration.MessagingLevelConfig;
import com.bnaqica.messagingservice.configuration.MessagingOperation;
import com.bnaqica.messagingservice.enums.OperationName;
import com.bnaqica.messagingservice.exceptions.MessagingServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static org.springframework.util.CollectionUtils.isEmpty;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessagingService {
    private MessagingConfig messagingConfig;


    public void processMessagingRequest(Map<String, String> processRequest) {

    }

    public String getMessagingConfig() {
        Map<String, MessagingLevelConfig> messageConfig = messagingConfig.getMessagingLevelConfigMap();

        if (isEmpty(messageConfig)) {
            throw new MessagingServiceException("Message config is empty");
        }

        for (Map.Entry<String, MessagingLevelConfig> entry : messageConfig.entrySet()) {

            MessagingLevelConfig messagingLevelConfig = messageConfig.get(entry.getKey());
            String producerId = entry.getKey();

            executeSteps(messagingLevelConfig, producerId);
        }

        return "";
    }

    private void executeSteps(MessagingLevelConfig messagingLevelConfig, String messagingCall) {
        if (messagingLevelConfig != null) {
            List<MessagingOperation> steps = messagingLevelConfig.getSteps();

            if (isEmpty(steps)) {
                throw new MessagingServiceException("No steps found");
            }

            for (MessagingOperation step : steps) {
                callStepDetails(step, messagingCall);
            }
        }
    }

    private void callStepDetails(MessagingOperation step, String messagingCall) {
        OperationName operationName = step.getOperationName();

        switch (operationName) {
            case CALL_REMOTE:
                log.info("Process call remote");
                break;

            case ADD_TO_TOPIC:
                log.info("Process add to topic");
                break;

            default:
                throw new MessagingServiceException("Unrecognized operation type: " + operationName);
        }
    }

}
