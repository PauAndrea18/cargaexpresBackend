/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.services;

import com.backend.cargaexpress.entities.SolicitudCarga;
import com.backend.cargaexpress.repositories.SolicitudCargaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class SolicitudCargaService {
    @Autowired
    private SolicitudCargaRepository solicitudCargaRepository;

    public SolicitudCarga crearSolicitud(SolicitudCarga solicitud) {
        solicitud.setEstado("PENDIENTE");
        return solicitudCargaRepository.save(solicitud);
    }

    public SolicitudCarga actualizarSolicitud(String id, SolicitudCarga solicitud) {
        solicitud.setId(id);
        return solicitudCargaRepository.save(solicitud);
    }

    public void eliminarSolicitud(String id) {
        solicitudCargaRepository.deleteById(id);
    }

    public SolicitudCarga obtenerSolicitud(String id) {
        return solicitudCargaRepository.findById(id).orElseThrow();
    }

    public List<SolicitudCarga> obtenerTodasLasSolicitudes() {
        return solicitudCargaRepository.findAll();
    }

    public List<SolicitudCarga> obtenerSolicitudesPendientes() {
        return solicitudCargaRepository.findByEstado("PENDIENTE");
    }

    public SolicitudCarga aplicarASolicitud(String solicitudId, String propietarioId) {
        SolicitudCarga solicitud = solicitudCargaRepository.findById(solicitudId).orElseThrow();
        solicitud.getPropietariosInteresados().add(propietarioId);
        return solicitudCargaRepository.save(solicitud);
    }
    
    public SolicitudCarga asignarSolicitud(String solicitudId, String propietarioId) {
        SolicitudCarga solicitud = solicitudCargaRepository.findById(solicitudId).orElseThrow();
        if (!solicitud.getPropietariosInteresados().contains(propietarioId)) {
            throw new IllegalArgumentException("Propietario no ha aplicado a esta solicitud");
        }
        solicitud.setEstado("ASIGNADA");
        solicitud.setPropietarioAsignadoId(propietarioId);
        return solicitudCargaRepository.save(solicitud);
    }
}
