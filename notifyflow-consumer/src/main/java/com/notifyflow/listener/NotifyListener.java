package com.notifyflow.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyListener {

    @KafkaListener(topics = "${notifyflow.topic}", groupId = "notifyflow-group")
    public void consume(String message) {
        System.out.println("📩 Notification Received: " + message);
    }
}
