/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.Remision;
import com.backend.cargaexpress.repositories.RemisionRepository;
import com.backend.cargaexpress.repositories.SolicitudCargaRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class RemisionService {
    @Autowired
    private RemisionRepository remisionRepository;
    
    @Autowired
    private SolicitudCargaRepository solicitudCargaRepository;
    
    public Remision crearRemision(String solicitudId, String placaCamion, String conductorId, String ruta) {
        Remision remision = new Remision();
        remision.setSolicitudId(solicitudId);
        remision.setFechaHoraRecogida(LocalDateTime.now());
        remision.setOrigen(solicitudCargaRepository.findById(solicitudId).orElseThrow().getOrigen());
        remision.setDestino(solicitudCargaRepository.findById(solicitudId).orElseThrow().getDestino());
        remision.setPlacaCamion(placaCamion);
        remision.setConductorId(conductorId);
        remision.setRuta(ruta);
        remision.setEstado("EN_RUTA");
        return remisionRepository.save(remision);
    }

    public Remision actualizarRemision(String id, Remision remision) {
        remision.setId(id);
        return remisionRepository.save(remision);
    }

    public void eliminarRemision(String id) {
        remisionRepository.deleteById(id);
    }

    public Remision obtenerRemision(String id) {
        return remisionRepository.findById(id).orElseThrow();
    }

    public List<Remision> obtenerTodasLasRemisiones() {
        return remisionRepository.findAll();
    }
    
    public Remision actualizarEstadoRemision(String id, String estado) {
        Remision remision = remisionRepository.findById(id).orElseThrow();
        remision.setEstado(estado);
        return remisionRepository.save(remision);
    }
    
    public Remision cerrarRemision(String id, String valoracion) {
        Remision remision = remisionRepository.findById(id).orElseThrow();
        remision.setEstado("CERRADA");
        remision.setValoracion(valoracion);
        return remisionRepository.save(remision);
    }
}
