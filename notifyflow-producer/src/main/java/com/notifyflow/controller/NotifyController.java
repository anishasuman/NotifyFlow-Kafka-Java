package com.notifyflow.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notify")
@CrossOrigin(origins = "*")
public class NotifyController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${notifyflow.topic}")
    private String topic;

    public NotifyController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendNotification(@RequestBody String message) {
        kafkaTemplate.send(topic, message);
        return "✅ Message sent: " + message;
    }
}
