package com.project.SoapWebService.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void consumeHello(String message) {
        System.out.println("Consumed message: " + message);
    }

//    @KafkaListener(topics = "writeTopic", groupId = "group_id")
//    public void consumeWrite(String message) {
//        System.out.println("Consumed message: " + message);
//    }
}