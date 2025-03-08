package com.backend.challenge.service;

import java.util.Optional;

public interface ICalculoService {
    double caclculaConPorcentaje(double num1, double num2);

    double obtenerPorcentajeSeguro();

    double obtenerPorcentaje();

    double actualizarPorcentaje(double nuevoPorcentaje);

    Optional<Double> recuperarPorcentajeCache();
}
