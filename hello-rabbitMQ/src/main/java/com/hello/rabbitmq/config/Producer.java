package com.hello.rabbitmq.config;

import com.hello.rabbitmq.config.com.hello.rabbilt.props.AppProps;
import com.hello.rabbitmq.entity.Event;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Producer {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
        this.rabbitTemplate.convertAndSend(AppProps.SIMPLE_ROUTING_KEY, message);
    }

    public void sendEvent(String routingKey , Event event){
        this.rabbitTemplate.convertAndSend(routingKey, event);
    }

    public void topicSend(Event event){
        this.rabbitTemplate.convertAndSend(AppProps.TOPIC_ROUTING_KEY_1, event);
    }
}
