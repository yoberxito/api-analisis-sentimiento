package com.hackathon.sentiment.api.service.impl;/*
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

import com.hackathon.sentiment.api.client.DsClient;
import com.hackathon.sentiment.api.dto.request.SentimientReq;
import com.hackathon.sentiment.api.dto.response.SentimentResponse;
import com.hackathon.sentiment.api.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
    private final DsClient dsClient;


    @Override
    public SentimentResponse evalAnlisisSentimiento(SentimientReq sentimientReq) {

        try {
            var result = dsClient.predict(sentimientReq.text());

            if (result != null) {

                Object previsionObj = result.get("prevision");
                if (previsionObj == null) previsionObj = result.get("prediction");
                if (previsionObj == null) previsionObj = result.get("sentiment");

                Object probObj = result.get("probabilidad");
                if (probObj == null) probObj = result.get("probability");
                if (probObj == null) probObj = result.get("score");

                if (previsionObj != null && probObj != null) {
                    String prevision = previsionObj.toString();

                    Double probabilidad;
                    if (probObj instanceof Number) {
                        probabilidad = ((Number) probObj).doubleValue();
                    } else {
                        probabilidad = Double.valueOf(probObj.toString());
                    }

                    return new SentimentResponse(prevision, probabilidad);
                }
            }

            // Si DS respondió pero no trajo campos esperados, cae a mock
            log.warn("Respuesta DS sin campos esperados. Usando MOCK. Respuesta: {}", result);

        } catch (Exception ex) {
            // DS no disponible / error de red / etc. -> mock
            log.warn("DataScience no disponible. Usando MOCK. Detalle: {}", ex.getMessage());
        }

        // MOCK por defecto mientras DS no esté listo
        return new SentimentResponse("Positivo", 0.87);
    }
}