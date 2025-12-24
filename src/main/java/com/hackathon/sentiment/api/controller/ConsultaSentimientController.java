package com.hackathon.sentiment.api.controller;/*
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
import com.hackathon.sentiment.api.dto.response.ErrorResponse;
import com.hackathon.sentiment.api.dto.response.SentimentResponse;
import com.hackathon.sentiment.api.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ConsultaSentimientController {

    private final ConsultaService consultaService;

    @PostMapping("/sentiment")
    public ResponseEntity<?> analisisSentimiento(@RequestBody SentimientReq sentimientReq) {

        if (sentimientReq == null || sentimientReq.text() == null || sentimientReq.text().trim().length() < 5) {
            return ResponseEntity
                    .badRequest()
                    .body(new ErrorResponse("El campo 'text' es obligatorio y debe tener al menos 5 caracteres"));
        }

        SentimentResponse response = consultaService.evalAnlisisSentimiento(sentimientReq);
        return ResponseEntity.ok(response);
    }
}
