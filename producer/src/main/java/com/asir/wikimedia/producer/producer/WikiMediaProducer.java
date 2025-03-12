package com.asir.wikimedia.producer.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikiMediaProducer {
    private final KafkaTemplate<String , String > kafkaTemplate;

    public WikiMediaProducer(KafkaTemplate<String , String > kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send("wikimedia-stream", message);
    }
}
