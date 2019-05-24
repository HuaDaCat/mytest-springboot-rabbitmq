package com.example.demo.receicer;

import com.example.demo.utils.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
public class TopicHelloReceiver {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TopicHelloReceiver.class);


    @RabbitListener(queues = "topic.message")    //监听器监听指定的Queue
    public void process1(String str, Channel channel,
                         @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        RabbitMQUtils.askMessage(channel, tag, LOGGER);
        System.out.println("message:" + str);
    }

    @RabbitListener(queues = "topic.messages")    //监听器监听指定的Queue
    public void process2(String str) {
        System.out.println("messages:" + str);
    }

}

