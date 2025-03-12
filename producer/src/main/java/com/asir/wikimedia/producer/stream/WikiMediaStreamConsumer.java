package com.asir.wikimedia.producer.stream;

import com.asir.wikimedia.producer.producer.WikiMediaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WikiMediaStreamConsumer {
    private final WebClient webClient;
    private final WikiMediaProducer producer;

    public WikiMediaStreamConsumer(
            WebClient.Builder webClientBuilder,
            WikiMediaProducer producer
    ) {
        this.webClient = webClientBuilder
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish() {
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(System.out::println);
    }
}
