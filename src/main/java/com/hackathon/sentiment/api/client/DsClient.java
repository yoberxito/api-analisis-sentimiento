package com.hackathon.sentiment.api.client;/*
 * Copyright (c) 2025 yober cieza coronel. Todos los derechos reservados.
 *
 * Este archivo es parte de api-analisis-sentimiento.
 *
 * api-analisis-sentimiento es software propietario: no puedes redistribuirlo y/o modificarlo sin el
 * permiso expreso del propietario. Está sujeto a los términos y condiciones
 * que acompañan el uso del software.
 *
 * Cualquier uso no autorizado puede ser sancionado según la ley vigente.
 */

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DsClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String DS_URL = "http://localhost:8000/predict";

    public Map<String, Object> predict(String text) {

        Map<String, String> body = Map.of("text", text);

        return restTemplate.postForObject(
                DS_URL,
                body,
                Map.class
        );
    }

}
