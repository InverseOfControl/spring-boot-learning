package com.gaohx.web.mq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "testQueue")
    public void receive(String msg){
        System.out.println(msg);
    }

}
