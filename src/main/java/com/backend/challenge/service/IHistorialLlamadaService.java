package com.backend.challenge.service;

import com.backend.challenge.entity.HistorialLlamada;

import java.util.List;

public interface IHistorialLlamadaService {

    void registrarLlamada (String endpoint, String params, String response, String error);
    List<HistorialLlamada> listarHistorialLlamadas();
}
