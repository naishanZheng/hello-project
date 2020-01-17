package com.hello.rabbitmq.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class Event implements Serializable {

    private String title;

    private String message;

    private Date time;

    private String from;
}
