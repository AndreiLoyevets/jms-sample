package com.aloievets.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;

/**
 * Created by Andrew on 22.05.2017.
 */
@Component
@Slf4j
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(final Order order) {
        log.info("Sending order {}", order);
        jmsTemplate.send(session -> {
            ObjectMessage objectMessage = session.createObjectMessage(order);
            return objectMessage;
        });
        log.info("Order sent");
    }
}
