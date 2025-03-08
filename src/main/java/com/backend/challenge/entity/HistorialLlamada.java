package com.backend.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "historial_llamada")
@AllArgsConstructor
@Builder
public class HistorialLlamada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorialLlamada;

    private String endpoint;

    private String parametros;

    @Column(columnDefinition = "TEXT")
    private String respuesta;

    @Column(columnDefinition = "TEXT")
    private String error;

    @Column(nullable = false, updatable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    public HistorialLlamada(String parametros, String endpoint, String respuesta, String error, LocalDateTime fecha) {
        this.parametros = parametros;
        this.endpoint = endpoint;
        this.respuesta = respuesta;
        this.error = error;
        this.fecha = fecha;
    }

    public HistorialLlamada() {
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
