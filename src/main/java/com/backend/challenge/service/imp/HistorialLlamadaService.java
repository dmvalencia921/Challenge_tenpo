package com.backend.challenge.service.imp;

import com.backend.challenge.entity.HistorialLlamada;
import com.backend.challenge.repository.HistorialLlamadaRepository;
import com.backend.challenge.service.IHistorialLlamadaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistorialLlamadaService implements IHistorialLlamadaService {

    @Autowired
    private  HistorialLlamadaRepository historialLlamadaRepository;

    /**
     * Metodo asincrono que permite registrar el historial de llamda sin afectar el rendimiento
     * @param endpoint
     * @param params
     * @param response
     * @param error
     */
    @Async
    @Override
    public void registrarLlamada(String endpoint, String params, String response, String error) {
        HistorialLlamada llamada = new HistorialLlamada();
        llamada.setEndpoint(endpoint);
        llamada.setParametros(params);
        llamada.setRespuesta(response);
        llamada.setError(error);
        llamada.setFecha(LocalDateTime.now());

        historialLlamadaRepository.save(llamada);
    }

    @Override
    public List<HistorialLlamada> listarHistorialLlamadas() {
        return historialLlamadaRepository.findAll();
    }


}
