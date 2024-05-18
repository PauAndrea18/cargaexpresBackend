/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.RutaEnvio;
import com.backend.cargaexpress.repositories.RutaEnvioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class RutaEnvioService {
    @Autowired
    private RutaEnvioRepository rutaEnvioRepository;

    public RutaEnvio crearRutaEnvio(RutaEnvio rutaEnvio) {
        return rutaEnvioRepository.save(rutaEnvio);
    }

    public RutaEnvio actualizarRutaEnvio(String id, RutaEnvio rutaEnvio) {
        rutaEnvio.setId(id);
        return rutaEnvioRepository.save(rutaEnvio);
    }

    public void eliminarRutaEnvio(String id) {
        rutaEnvioRepository.deleteById(id);
    }

    public RutaEnvio obtenerRutaEnvio(String id) {
        return rutaEnvioRepository.findById(id).orElseThrow();
    }

    public List<RutaEnvio> obtenerTodasLasRutasEnvio() {
        return rutaEnvioRepository.findAll();
    }
}
