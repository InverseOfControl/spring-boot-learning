package com.gaohx.web.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActivemqConfiguration {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("queue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("topic");
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(new ActiveMQConnectionFactory());
    }
}
