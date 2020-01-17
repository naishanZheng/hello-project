package com.hello.rabbitmq.config;
import com.hello.rabbitmq.config.com.hello.rabbilt.props.AppProps;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    /**
     * 声明一个名为simple的队列
     */
    @Bean
    public Queue simpleQueue() {
        return new Queue(AppProps.SIMPLE_ROUTING_KEY);
    }

    @Bean
    public Queue eventQueue() {
        return new Queue(AppProps.EVENT_ROUTING_KEY);
    }

    @Bean(name = AppProps.TOPIC_ROUTING_KEY_1)
    public Queue topicQueue1(){
        return new Queue(AppProps.TOPIC_ROUTING_KEY_1);
    }
    @Bean(name = AppProps.TOPIC_ROUTING_KEY_2)
    public Queue topicQueue2(){
        return new Queue(AppProps.TOPIC_ROUTING_KEY_2);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(AppProps.TOPIC_EXCHANGE);
    }

    @Bean
    Binding bindingExchangeMessage1(@Qualifier(AppProps.TOPIC_ROUTING_KEY_1) Queue topicQueue, TopicExchange exchange) {
        //将routingkey绑定
        return BindingBuilder.bind(topicQueue).to(exchange).with(AppProps.TOPIC_ROUTING_KEY_1);
    }

    @Bean
    Binding bindingExchangeMessage2(@Qualifier(AppProps.TOPIC_ROUTING_KEY_2) Queue topicQueue, TopicExchange exchange) {
        //将routingkey绑定
        return BindingBuilder.bind(topicQueue).to(exchange).with(AppProps.TOPIC_ROUTING_KEY_2);
    }
}
