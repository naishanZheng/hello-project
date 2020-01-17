package com.hello.rabbitmq;

import com.hello.rabbitmq.config.Producer;
import com.hello.rabbitmq.config.com.hello.rabbilt.props.AppProps;
import com.hello.rabbitmq.entity.Event;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

public class ProducerTest extends BaseTest{
    @Resource
    private Producer producer;

    @Test
    public void test() throws IOException, TimeoutException, InterruptedException {
        producer.send("hello");
    }


    @Test
    public void sendEvent(){
        Event event = new Event();
        event.setFrom("zns");
        event.setMessage("helloEvent");
        event.setTime(new Date());
        event.setTitle("rabbit");
        producer.sendEvent(AppProps.EVENT_ROUTING_KEY, event);
    }

    @Test
    public void topicSend(){
        Event event = new Event();
        event.setFrom("zns");
        event.setMessage("helloTopicEvent");
        event.setTime(new Date());
        event.setTitle("topic");
        producer.topicSend(event);
    }
}
