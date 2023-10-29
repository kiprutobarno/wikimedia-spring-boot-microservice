package com.tuts.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.tuts.db.model.WikimediaData;
import com.tuts.db.repository.WikimediaDataRepository;

@Service
public class KafkaDatabaseConsumer {
    @Autowired
    private WikimediaDataRepository repository;

    @KafkaListener(topics = "wikimedia_recent_changes", groupId = "myGroup")
    public void consume(String eventMessage) {
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }
}
