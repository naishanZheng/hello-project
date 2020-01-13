package com.hello.mongodb.config;

import com.hello.mongodb.config.props.MultipleMongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.hello.mongodb.service",
        mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {
}
