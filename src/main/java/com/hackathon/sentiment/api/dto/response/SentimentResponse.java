package com.hackathon.sentiment.api.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record SentimentResponse(String prevision, Double probabilidad) {
}

