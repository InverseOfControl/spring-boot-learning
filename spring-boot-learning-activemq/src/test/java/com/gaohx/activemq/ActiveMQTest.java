package com.gaohx.activemq;

import com.gaohx.activemq.web.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMQTest {

    @Autowired
    private Sender sender;

    @Test
    public void sendMsg() {
        sender.sendMsg("Hello World");
    }

    @Test
    public void sendTopicMsg() {
        sender.sendTopicMsg("Hello World");
    }

}
