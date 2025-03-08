package com.backend.challenge.service.imp;

import com.backend.challenge.entity.HistorialLlamada;
import com.backend.challenge.service.ICalculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculoService implements ICalculoService {

    @Autowired
    private  HistorialLlamadaService llamadaService;

    @Override
    public double caclculaConPorcentaje(double num1, double num2) {
        double porcentaje = obtenerPorcentaje();
        double resultado = num1 + num2;
         resultado += (resultado*porcentaje/100);
        System.out.println("porcentaje "+ porcentaje);
        String parametros = "num1=" + num1 + "&num2=" + num2 + "&porcentaje=" + porcentaje;
        String respuesta = "resultado=" + resultado;
        llamadaService.registrarLlamada("/api/calculo", parametros, respuesta,null);
        return resultado;
    }

    /**
     * Método que maneja fallos del servicio externo y usa el último valor almacenado
     * @return
     */
    @Override
    public double obtenerPorcentajeSeguro() {
        try {
            return obtenerPorcentaje();
        } catch (Exception e) {
            return recuperarPorcentajeCache().orElseThrow(() ->
                    new RuntimeException("Error al obtener el porcentaje y no hay valor en caché"));
        }
    }

    /**
     * simulamos el mock fijo con 10
     * @return
     */
    @Cacheable(value = "porcentajeCache")
    @Override
    public double obtenerPorcentaje() {
        //Simula fallo en un 20% de los cassos
        if(Math.random()<0.2){
            throw new RuntimeException("Fallo en el servicio externo");
        }
        return actualizarPorcentaje(10.0);
    }

    @CachePut(value = "porcentajeCache")
    @Override
    public double actualizarPorcentaje(double nuevoPorcentaje) {
        return nuevoPorcentaje;
    }

    @Cacheable(value = "porcentajeCache")
    @Override
    public Optional<Double> recuperarPorcentajeCache() {
        return Optional.empty(); // Si el caché está vacío, devuelve vacío
    }


}
