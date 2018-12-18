package com.gaohx.activemq.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class Sender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendMsg(String text) {
        for (int i = 0; i < 20; i++) {
            jmsMessagingTemplate.convertAndSend(this.queue, text + i);
        }
    }

    public void sendTopicMsg(String text) {
        jmsMessagingTemplate.convertAndSend(this.topic, text);
    }

}
