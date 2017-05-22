package com.aloievets.jms;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.Collections;

/**
 * Created by Andrew on 22.05.2017.
 */
@Configuration
@ComponentScan
@EnableJms // auto-detect listeners annotated with @JmsListener
public class AppConfig {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    public static final String QUEUE_NAME = "testQueue";

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Collections.singletonList("com.aloievets.jms"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ActiveMQConnectionFactory connectionFactory){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultDestinationName(QUEUE_NAME);
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-1");
        return factory;
    }
}
