package com.tuts.producer;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class WikimediaChangesHandler implements EventHandler {

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onComment(String arg0) throws Exception {

    }

    @Override
    public void onError(Throwable arg0) {
    }

    @Override
    public void onMessage(String arg0, MessageEvent arg1) throws Exception {
        log.info("event data -> " + arg1.getData());

        kafkaTemplate.send(topic, arg1.getData());
    }

    @Override
    public void onOpen() throws Exception {
    }

}
