package com.hello.rabbitmq;

import com.hello.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.*;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitConsumerTest extends BaseTest {

    @Resource
    private RabbitMQConfig rabbitMQConfig;

    @Test
    public void test() throws IOException, TimeoutException, InterruptedException {
        Address[] addresses = new Address[] {
                new Address(rabbitMQConfig.getIpAddress() , rabbitMQConfig.getPort())
        };

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(rabbitMQConfig.getUserName());
        factory.setPassword(rabbitMQConfig.getPassword());
        //这里的连接方式与生产者的 demo 略有不同 注意辨别区别
        Connection connection = factory.newConnection(addresses); // 创建连接
        final Channel channel = connection.createChannel(); // 创建信道
        channel.basicQos(64); // 设置客户端最多接收未被 ack 的消息的个数
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException {
                System.out.println(" recv message: " + new String(body));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(rabbitMQConfig.getQueueName(), consumer);
        //等待回调函数执行完毕之后 关闭资源
        TimeUnit.SECONDS.sleep(5);
        channel.close();
        connection.close();
    }
}
