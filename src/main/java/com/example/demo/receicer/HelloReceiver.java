package com.example.demo.receicer;

import com.example.demo.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {
    @RabbitListener(queues = "hello")    //监听器监听指定的Queue
    public void process1(String str) {
        System.out.println("Receive:" + str);
    }

    @RabbitListener(queues = "hello1")
    public void process2(User user) {
        System.out.println("Receive1" + user);
    }
}
