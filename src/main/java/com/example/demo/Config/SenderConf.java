package com.example.demo.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SenderConf {
    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Bean
    public Queue queue1() {
        return new Queue("hello1");
    }
}
