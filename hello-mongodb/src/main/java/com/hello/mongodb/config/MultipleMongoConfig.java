package com.hello.mongodb.config;

import com.hello.mongodb.config.props.MultipleMongoProperties;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.annotation.Resource;

@Configuration
public class MultipleMongoConfig {

    @Resource
    private MultipleMongoProperties multipleMongoProperties;


    @Primary
    @Bean(name = "primaryMongoTemplate")
    public MongoTemplate primaryMongoTemplate() throws Exception {
        return new MongoTemplate(primaryFactory());
    }

    @Bean
    @Qualifier("secondaryMongoTemplate")
    public MongoTemplate secondaryMongoTemplate() throws Exception {
        return new MongoTemplate(secondaryFactory());
    }

    @Bean
    @Primary
    public MongoDbFactory primaryFactory() throws Exception {
        MongoClient client = new MongoClient(new MongoClientURI(multipleMongoProperties.getPrimary().getUri()));
        return new SimpleMongoDbFactory(client, multipleMongoProperties.getPrimary().getDatabase());
    }

    @Bean
    public MongoDbFactory secondaryFactory() throws Exception {
        MongoClient client = new MongoClient(new MongoClientURI(multipleMongoProperties.getSecondary().getUri()));
        return new SimpleMongoDbFactory(client, multipleMongoProperties.getSecondary().getDatabase());
    }
}
