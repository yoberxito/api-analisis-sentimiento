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

import com.hackathon.sentiment.api.dto.request.SentimientReq;
import com.hackathon.sentiment.api.dto.response.SentimentResponse;
import com.hackathon.sentiment.api.service.ConsultaService;
import org.springframework.stereotype.Service;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Override
    public SentimentResponse evalAnlisisSentimiento(SentimientReq sentimientReq) {
        // TODO: aquí luego integran el modelo / Data Science
        return new SentimentResponse("Positivo", 0.87);
    }
}

