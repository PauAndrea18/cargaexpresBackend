/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.Vehiculo;
import com.backend.cargaexpress.repositories.VehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public Vehiculo crearVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public Vehiculo actualizarVehiculo(String id, Vehiculo vehiculo) {
        vehiculo.setId(id);
        return vehiculoRepository.save(vehiculo);
    }

    public void eliminarVehiculo(String id) {
        vehiculoRepository.deleteById(id);
    }

    public Vehiculo obtenerVehiculo(String id) {
        return vehiculoRepository.findById(id).orElseThrow();
    }

    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepository.findAll();
    }
}