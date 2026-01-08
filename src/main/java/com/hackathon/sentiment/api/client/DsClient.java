package com.hackathon.sentiment.api.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DsClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${ds.url}")
    private String dsUrl;

    public Map<String, Object> predict(String text) {
        Map<String, String> body = Map.of("text", text);

        return restTemplate.postForObject(
                dsUrl,
                body,
                Map.class
        );
    }
}
