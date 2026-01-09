package com.hackathon.sentiment.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SentimentResponse(String prevision, Double probabilidad) {
}

