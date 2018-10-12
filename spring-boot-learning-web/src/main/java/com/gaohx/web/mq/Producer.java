package com.gaohx.web.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void send(){
        jmsMessagingTemplate.convertAndSend("testQueue","hello");

    }

}
