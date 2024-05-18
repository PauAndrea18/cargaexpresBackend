/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.controllers;

import com.backend.cargaexpress.entities.ReporteUbicacion;
import com.backend.cargaexpress.services.ReporteUbicacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */

@RestController
@RequestMapping("/reportes")
public class ReporteUbicacionController {
    @Autowired
    private ReporteUbicacionService reporteUbicacionService;

    @PostMapping
    public ReporteUbicacion crearReporteUbicacion(@RequestParam String remisionId, @RequestParam String ubicacionActual,
                                                  @RequestParam String novedad) {
        return reporteUbicacionService.crearReporteUbicacion(remisionId, ubicacionActual, novedad);
    }

    @GetMapping("/{remisionId}")
    public List<ReporteUbicacion> obtenerReportesPorRemision(@PathVariable String remisionId) {
        return reporteUbicacionService.obtenerReportesPorRemision(remisionId);
    }
}
