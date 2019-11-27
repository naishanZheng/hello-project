package com.hello.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com"})
//@ServletComponentScan("com.bbt.trademark.rest.framework")
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestApplication.class);
        springApplication.run(args);
    }
}
