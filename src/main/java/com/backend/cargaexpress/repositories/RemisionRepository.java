/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.cargaexpress.repositories;

import com.backend.cargaexpress.entities.Remision;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USER
 */
public interface RemisionRepository extends MongoRepository<Remision, String> {
    List<Remision> findByPlacaCamionAndFechaHoraRecogidaBetween(String placaCamion, LocalDateTime desde, LocalDateTime hasta);
    List<Remision> findByPlacaCamion(String placaCamion);
    List<Remision> findByPlacaCamionAndFechaHoraEntrega(String placaCamion, LocalDateTime fechaHora);
}
