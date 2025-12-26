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
import com.hackathon.sentiment.api.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultaServiceImpl implements ConsultaService {
    private final DsClient dsClient;

    @Override
    public Object evalAnlisisSentimiento(SentimientReq sentimientReq) {
        try {



        Map<String, Object> result = dsClient.predict(sentimientReq.text());

        return new Object(
                result.get("prevision").toString(),
                Double.valueOf(result.get("probabilidad").toString())
        );
        }catch (Exception e){
            throw new  RuntimeException(e);
        }
    }
}
