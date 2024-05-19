/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.Remision;
import com.backend.cargaexpress.entities.ReporteUbicacion;
import com.backend.cargaexpress.repositories.RemisionRepository;
import com.backend.cargaexpress.repositories.ReporteUbicacionRepository;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service
public class EstadisticasService {
    @Autowired
    private RemisionRepository remisionRepository;

    @Autowired
    private ReporteUbicacionRepository reporteUbicacionRepository;

    public long obtenerNumeroDeViajesPorCamion(String placaCamion, LocalDate desde, LocalDate hasta) {
        return remisionRepository.findByPlacaCamionAndFechaHoraRecogidaBetween(placaCamion, desde.atStartOfDay(), hasta.atTime(23, 59, 59)).size();
    }

    public double calcularTiempoPromedioPorViaje(String placaCamion) {
        List<Remision> remisiones = remisionRepository.findByPlacaCamion(placaCamion);
        double totalTiempo = remisiones.stream()
                .filter(remision -> remision.getFechaHoraEntrega() != null)
                .mapToDouble(remision -> Duration.between(remision.getFechaHoraRecogida(), remision.getFechaHoraEntrega()).toHours())
                .sum();
        return totalTiempo / remisiones.size();
    }

    public double obtenerNumeroDeToneladasTransportadasPorMes(String placaCamion, LocalDateTime fechaHora) {
        List<Remision> remisiones = remisionRepository.findByPlacaCamionAndFechaHoraEntrega(placaCamion, fechaHora);
        return remisiones.stream().mapToDouble(Remision::getPesoTotal).sum();
    }

    public double obtenerDistanciaRecorridaDiariamentePorCamion(String remisionId, LocalDateTime fecha) {
        List<ReporteUbicacion> reportes = reporteUbicacionRepository.findByRemisionIdAndFechaHoraReporte(remisionId, fecha);
        return reportes.stream().mapToDouble(ReporteUbicacion::getDistanciaRecorrida).sum();
    }
}
