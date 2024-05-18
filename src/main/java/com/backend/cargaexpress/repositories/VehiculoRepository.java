/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.cargaexpress.repositories;

import com.backend.cargaexpress.entities.Vehiculo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USER
 */
public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
}
