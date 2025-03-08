package com.backend.challenge.restcontroller;

import com.backend.challenge.entity.HistorialLlamada;
import com.backend.challenge.service.imp.HistorialLlamadaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
public class HistorialLlamadaRestController {

    @Autowired
    private  HistorialLlamadaService llamadaService;


    @GetMapping("/listarHistorial")
   @Operation(summary = "metodo listar", description = "Metodo usado para listar el historial de llamadas")
    public ResponseEntity<List<HistorialLlamada>> listarHistorialLlamadas() {
        return ResponseEntity.ok(llamadaService.listarHistorialLlamadas());
    }
}
