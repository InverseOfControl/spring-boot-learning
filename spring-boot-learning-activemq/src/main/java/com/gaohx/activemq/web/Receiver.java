package com.gaohx.activemq.web;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "test-queue")
    public void receiveMsg1(String text) {
        System.out.println("consumer1:" + text);
    }

    @JmsListener(destination = "test-topic", containerFactory = "topicListenerFactory")
    public void receiveMsg2(String text) {
        System.out.println("receiveMsg2:" + text);
    }

    @JmsListener(destination = "test-topic", containerFactory = "topicListenerFactory")
    public void receiveMsg3(String text) {
        System.out.println("receiveMsg3:" + text);
    }

}
