package com.aloievets.jms;

/**
 * Created by Andrew on 22.05.2017.
 */
public class Launcher {

    private static final String QUEUE_NAME = "testQueue";

    public static void main(String[] args) throws Exception {
        startProducer();
        startProducer();
        startConsumer();
        Thread.sleep(1000);
        startConsumer();
        startProducer();
        startConsumer();
        startProducer();
        Thread.sleep(1000);
        startConsumer();
        startProducer();
        startConsumer();
        startConsumer();
        startProducer();
        startProducer();
        Thread.sleep(1000);
        startProducer();
        startConsumer();
        startConsumer();
        startProducer();
        startConsumer();
        startProducer();
        startConsumer();
        startProducer();
        startConsumer();
        startConsumer();
        startProducer();
    }

    public static void startProducer() {
        new Thread(new Producer(QUEUE_NAME)).start();
    }

    public static void startConsumer() {
        new Thread(new Consumer(QUEUE_NAME)).start();
    }

}
