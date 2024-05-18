/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.cargaexpress.repositories;

import com.backend.cargaexpress.entities.SolicitudCarga;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USER
 */
public interface SolicitudCargaRepository extends MongoRepository<SolicitudCarga, String> {
    List<SolicitudCarga> findByEstado(String estado);
}