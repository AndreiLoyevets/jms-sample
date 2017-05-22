package com.aloievets.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

/**
 * Created by Andrew on 22.05.2017.
 */
@Component
@Slf4j
public class MessageReceiver {

    @JmsListener(destination = AppConfig.QUEUE_NAME)
    public void receiveMessage(final Message<Order> message) {
        MessageHeaders headers = message.getHeaders();
        log.info("Received: headers : {}", headers);
        Order response = message.getPayload();
        log.info("Received : body: {}", response);
    }
}