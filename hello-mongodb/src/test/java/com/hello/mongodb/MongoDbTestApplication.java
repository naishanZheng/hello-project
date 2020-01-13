package com.hello.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.hello" })
public class MongoDbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbTestApplication.class, args);
	}

}
