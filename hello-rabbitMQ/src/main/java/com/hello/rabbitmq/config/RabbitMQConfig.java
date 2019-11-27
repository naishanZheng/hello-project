package com.hello.rabbitmq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="rabbit")
public class RabbitMQConfig {

    private String queueName;//队列名

    private String ipAddress;//ip

    private int port;//端口

    private String userName;//用户名称

    private String password;//密码
}
