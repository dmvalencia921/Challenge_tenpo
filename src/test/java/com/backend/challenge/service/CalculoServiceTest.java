package com.backend.challenge.service;

import com.backend.challenge.service.imp.CalculoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculoServiceTest {

    @InjectMocks
    private CalculoService calculoService;

    @Mock
    private CacheManager cacheManager;

    @Mock
    private Cache cache;

    @Test
    void calcularConPorcentaje_DeberiaCalcularCorrectamente() {
        double num1 = 100;
        double num2 = 50;
        double porcentaje = 10; // 10% adicional

        double resultado = calculoService.caclculaConPorcentaje(num1, num2);

        assertEquals(165.0, resultado, 0.01); // Verificamos con margen de error mínimo
    }

    @Test
    void obtenerPorcentaje_DeberiaUsarCacheSiEstaDisponible() {
        // Simulamos que el caché ya tiene un porcentaje guardado (15%)
        Mockito.when(cacheManager.getCache("porcentajeCache")).thenReturn(cache);
        Mockito.when(cache.get(Mockito.any(), Mockito.eq(Double.class))).thenReturn(15.0);

        double porcentaje = calculoService.obtenerPorcentajeSeguro();

        assertEquals(15.0, porcentaje); // Verificamos que usa el caché
        Mockito.verify(cache, Mockito.times(1)).get(Mockito.any(), Mockito.eq(Double.class));
    }

    @Test
    void obtenerPorcentaje_DeberiaRetornarValorPorDefectoSiNoHayCache() {
        // Simulamos que el caché está vacío
        Mockito.when(cacheManager.getCache("porcentajeCache")).thenReturn(cache);
        Mockito.when(cache.get(Mockito.any(), Mockito.eq(Double.class))).thenReturn(null);

        double porcentaje = calculoService.obtenerPorcentajeSeguro();

        assertEquals(10.0, porcentaje); // Valor por defecto si no hay caché
    }
}
