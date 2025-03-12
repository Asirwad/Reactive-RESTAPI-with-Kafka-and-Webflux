package com.asir.wikimedia.producer.rest;

import com.asir.wikimedia.producer.stream.WikiMediaStreamConsumer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
public class WikiMediaController {
    private final WikiMediaStreamConsumer streamConsumer;

    public WikiMediaController(WikiMediaStreamConsumer streamConsumer) {
        this.streamConsumer = streamConsumer;
    }

    @GetMapping("/stream")
    public void streamWikiMedia() {
        streamConsumer.consumeStreamAndPublish();
    }
}
