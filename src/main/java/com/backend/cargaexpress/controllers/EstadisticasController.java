/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.controllers;

import com.backend.cargaexpress.services.EstadisticasService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {
    @Autowired
    private EstadisticasService estadisticasService;

    @GetMapping("/viajes")
    public long obtenerNumeroDeViajes(@RequestParam String placaCamion, @RequestParam LocalDate desde, @RequestParam LocalDate hasta) {
        return estadisticasService.obtenerNumeroDeViajesPorCamion(placaCamion, desde, hasta);
    }

    @GetMapping("/tiempo-promedio")
    public double calcularTiempoPromedioPorViaje(@RequestParam String placaCamion) {
        return estadisticasService.calcularTiempoPromedioPorViaje(placaCamion);
    }

    @GetMapping("/toneladas-transportadas")
    public double obtenerNumeroDeToneladasTransportadasPorMes(@RequestParam String placaCamion, @RequestParam LocalDateTime fechaHora) {
        return estadisticasService.obtenerNumeroDeToneladasTransportadasPorMes(placaCamion, fechaHora);
    }

    @GetMapping("/distancia-recorrida")
    public double obtenerDistanciaRecorridaDiariamentePorCamion(@RequestParam String placaCamion, @RequestParam LocalDateTime fecha) {
        return estadisticasService.obtenerDistanciaRecorridaDiariamentePorCamion(placaCamion, fecha);
    }
}
