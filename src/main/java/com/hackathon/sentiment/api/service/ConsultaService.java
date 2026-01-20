package com.hackathon.sentiment.api.service;/*
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

public interface ConsultaService {
    SentimentResponse evalAnlisisSentimiento(SentimientReq sentimientReq) throws Exception;
}
