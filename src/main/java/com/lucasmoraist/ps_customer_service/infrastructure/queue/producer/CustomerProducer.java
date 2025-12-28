package com.lucasmoraist.ps_customer_service.infrastructure.queue.producer;

import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class CustomerProducer {

    private static final String OUTPUT_BINDING_NAME = "toNotificationService-out-0";

    private final StreamBridge streamBridge;

    public CustomerProducer(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void sendMessage(Message<?> message) {
        log.info("Sending message to payment service");
        streamBridge.send(OUTPUT_BINDING_NAME, message);
    }

}
