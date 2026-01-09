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

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
    private final DsClient dsClient;


    @Override
    public SentimentResponse evalAnlisisSentimiento(SentimientReq sentimientReq) {

        try {
            var result = dsClient.predict(sentimientReq.text());
            log.info("result:{}",result);

            Object previsionObj1 = result.get("texto");
            log.info("previsionObj1:{}",previsionObj1);

            if (result != null) {

                Object previsionObj = result.get("prevision");


                Object probObj = result.get("confianza");

                if (previsionObj != null && probObj != null) {
                    log.info("previsionObj1:{}", previsionObj1);

                    Double probabilidad;
                    if (probObj instanceof Number) {
                        probabilidad = ((Number) probObj).doubleValue();
                    } else {
                        probabilidad = Double.valueOf(probObj.toString());
                    }

                    return new SentimentResponse(previsionObj.toString(), probabilidad);
                }else {
                    throw new RuntimeException("Algun response es null");
                }

            }else {
                throw new RuntimeException("la consulta resultado null");

            }


        } catch (Exception ex) {
            // DS no disponible / error de red / etc. -> mock
            log.warn("DataScience no disponible. Usando MOCK. Detalle: {}", ex.getMessage());
            throw new RuntimeException("Error en la consulta");

        }
    }
}