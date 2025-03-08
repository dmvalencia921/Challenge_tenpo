package com.backend.challenge.restcontroller;

import com.backend.challenge.service.imp.CalculoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculo")
public class CalculoRestController {

    @Autowired
    private  CalculoService calculoService;

    @GetMapping("/cacular")
    @Operation(summary = "metodo calcular", description = "metodo usado para hacer el calculo")
    public ResponseEntity<Double> calcular (@RequestParam double num1 , @RequestParam double num2 ) {
        return ResponseEntity.ok(calculoService.caclculaConPorcentaje(num1, num2));
    }
    
}
