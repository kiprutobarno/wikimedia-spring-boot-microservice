package com.tuts.db;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaDatabaseConsumer {
    @KafkaListener(topics = "wikimedia_recent_changes", groupId = "myGroup")
    public void consume(String eventMessage) {
        log.info("Event message received -> " + eventMessage);
    }
}
