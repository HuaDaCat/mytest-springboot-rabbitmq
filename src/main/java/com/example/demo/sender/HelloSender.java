package com.example.demo.sender;

import com.example.demo.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        template.convertAndSend("hello", "hello,rabbit~");
    }

    public void send1() {
        User user = new User();
        user.setName("VAN");
        user.setPass("123");
        template.convertAndSend("hello1", user);
    }

    public void send2() {
        template.convertAndSend("exchange", "topic.message", "hello,rabbit!");
    }

    public void send3() {
        template.convertAndSend("fanoutExchange", "", "xixi,hlhdidi");
    }
}
