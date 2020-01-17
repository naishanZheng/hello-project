package com.hello.rabbitmq.config;

import com.hello.rabbitmq.config.com.hello.rabbilt.props.AppProps;
import com.hello.rabbitmq.entity.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = AppProps.SIMPLE_ROUTING_KEY)
    public void receive(String message) {
        log.info("消费者1收到消息：{}", message);
    }

    @RabbitListener(queues = AppProps.EVENT_ROUTING_KEY)
    public void receiveEvent(Event event) {
        log.info("event消费者1收到消息：{}", event);
    }


    @RabbitListener(queues = AppProps.TOPIC_ROUTING_KEY_1)
    public void receiveTopicEvent1(Event event) {
        log.info("topic消费者1收到消息：{}", event);
    }

    @RabbitListener(queues = AppProps.TOPIC_ROUTING_KEY_2)
    public void receiveTopicEvent2(Event event) {
        log.info("topic消费者1收到消息：{}", event);
    }

}
