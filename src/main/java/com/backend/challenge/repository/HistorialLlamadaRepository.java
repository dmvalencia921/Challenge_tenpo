package com.backend.challenge.repository;

import com.backend.challenge.entity.HistorialLlamada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialLlamadaRepository  extends JpaRepository<HistorialLlamada, Long> {

    /**
     * Obtenemos la lsita del historial
     * @return lista de historial
     */
    List<HistorialLlamada> findAll();
}
