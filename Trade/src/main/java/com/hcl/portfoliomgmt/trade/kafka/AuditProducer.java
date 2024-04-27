package com.hcl.portfoliomgmt.trade.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuditProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendAuditMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
