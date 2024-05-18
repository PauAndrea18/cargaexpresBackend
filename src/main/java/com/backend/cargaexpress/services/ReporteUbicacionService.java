/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.ReporteUbicacion;
import com.backend.cargaexpress.repositories.ReporteUbicacionRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service
public class ReporteUbicacionService {
    @Autowired
    private ReporteUbicacionRepository reporteUbicacionRepository;

    public ReporteUbicacion crearReporteUbicacion(String remisionId, String ubicacionActual, String novedad) {
        ReporteUbicacion reporte = new ReporteUbicacion();
        reporte.setRemisionId(remisionId);
        reporte.setFechaHoraReporte(LocalDateTime.now());
        reporte.setUbicacionActual(ubicacionActual);
        reporte.setNovedad(novedad);
        return reporteUbicacionRepository.save(reporte);
    }

    public List<ReporteUbicacion> obtenerReportesPorRemision(String remisionId) {
        return reporteUbicacionRepository.findByRemisionId(remisionId);
    }
}
