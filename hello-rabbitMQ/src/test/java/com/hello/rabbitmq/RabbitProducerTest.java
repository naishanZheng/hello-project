package com.hello.rabbitmq;


import com.hello.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitProducerTest extends BaseTest {

    @Resource
    private RabbitMQConfig rabbitMQConfig;

    private static final String EXCHANGE_NAME = "exchange demo";
    private static final String ROUTING_KEY = "routingkey demo";

    @Test
    public void test() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMQConfig.getIpAddress());
        factory.setPort(rabbitMQConfig.getPort());
        factory.setUsername(rabbitMQConfig.getUserName());
        factory.setPassword(rabbitMQConfig.getPassword());
        Connection connection = factory.newConnection();// 创建连接
        Channel channel = connection.createChannel();// 创建信道
// 创建一个 type="direct" 、持久化的、非自动删除的交换器
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true, false, null);
//创建一个持久化、非排他的、非自动删除的队列
        channel.queueDeclare(rabbitMQConfig.getQueueName(), true, false, false, null);
//将交换器与队列通过路由键绑定
        channel.queueBind(rabbitMQConfig.getQueueName(), EXCHANGE_NAME, ROUTING_KEY);
//发送一条持久化的消息: hello world !
        String message = "Hello World !";
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY,
                MessageProperties.PERSISTENT_TEXT_PLAIN,
                message.getBytes());
//关闭资源
        channel.close();
        connection.close();
    }
}
