package com.aloievets.jms;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Andrew on 22.05.2017.
 */
public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context
                .getBean(MessageSender.class)
                .sendMessage(
                        Order.builder()
                                .orderId("123456")
                                .productName("BMW Wheels")
                                .quantity(4)
                                .build()
                );

        Thread.sleep(10000);

        context.close();
    }
}
