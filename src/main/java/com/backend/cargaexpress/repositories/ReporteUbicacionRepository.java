/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.cargaexpress.repositories;

import com.backend.cargaexpress.entities.ReporteUbicacion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author User
 */
public interface ReporteUbicacionRepository extends MongoRepository<ReporteUbicacion, String> {
    List<ReporteUbicacion> findByRemisionId(String remisionId);
    List<ReporteUbicacion> findByRemisionIdAndFechaHoraReporte(String remisionId, LocalDateTime fecha);
}
