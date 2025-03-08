package com.backend.challenge.service;

import com.backend.challenge.entity.HistorialLlamada;
import com.backend.challenge.repository.HistorialLlamadaRepository;
import com.backend.challenge.service.imp.HistorialLlamadaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class HistorialLlamadasSericesTest {

    @Mock
    private HistorialLlamadaRepository historialLlamadaRepository;
    @InjectMocks
    private HistorialLlamadaService historialLlamadaService;

    private HistorialLlamada llamada1;
    private HistorialLlamada llamada2;

    @BeforeEach
    void setUp() {
        llamada1 = new HistorialLlamada( "/api/calculo", "num1=10&num2=5", "resultado=16.5", null, LocalDateTime.now());
        llamada2 = new HistorialLlamada( "/api/calculo", "num1=20&num2=10", "resultado=33.0", null, LocalDateTime.now());
    }

    @Test
    void obtenerHistorial_DeberiaRetornarListaDeLlamadas() {
        // Simulación del comportamiento del repositorio
        Mockito.when(historialLlamadaRepository.findAll()).thenReturn(Arrays.asList(llamada1, llamada2));

        // Llamamos al servicio
        List<HistorialLlamada> historial = historialLlamadaService.listarHistorialLlamadas();

        // Verificamos el resultado
        assertEquals(2, historial.size());
        assertEquals("/api/calculo", historial.get(0).getEndpoint());

        // Verificamos que se llamó al método una vez
        Mockito.verify(historialLlamadaRepository, Mockito.times(1)).findAll();
    }

    @Test
    void registrarLlamada_DeberiaGuardarHistorial() {
        // Simulación del guardado en el repositorio
        historialLlamadaService.registrarLlamada("/api/test", "param=test", "respuesta=ok", null);

        // Verificamos que `save()` fue llamado una vez
        Mockito.verify(historialLlamadaRepository, Mockito.times(1)).save(Mockito.any(HistorialLlamada.class));
    }
}
