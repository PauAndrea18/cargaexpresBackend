/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.controllers;

import com.backend.cargaexpress.entities.SolicitudCarga;
import com.backend.cargaexpress.services.SolicitudCargaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/solicitudes")
public class SolicitudCargaController {
    @Autowired
    private SolicitudCargaService solicitudCargaService;

    @PostMapping
    public SolicitudCarga crearSolicitud(@RequestBody SolicitudCarga solicitud) {
        return solicitudCargaService.crearSolicitud(solicitud);
    }

    @PutMapping("/{id}")
    public SolicitudCarga actualizarSolicitud(@PathVariable String id, @RequestBody SolicitudCarga solicitud) {
        return solicitudCargaService.actualizarSolicitud(id, solicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable String id) {
        solicitudCargaService.eliminarSolicitud(id);
    }

    @GetMapping("/{id}")
    public SolicitudCarga obtenerSolicitud(@PathVariable String id) {
        return solicitudCargaService.obtenerSolicitud(id);
    }

    @GetMapping
    public List<SolicitudCarga> obtenerTodasLasSolicitudes() {
        return solicitudCargaService.obtenerTodasLasSolicitudes();
    }

    @GetMapping("/pendientes")
    public List<SolicitudCarga> obtenerSolicitudesPendientes() {
        return solicitudCargaService.obtenerSolicitudesPendientes();
    }
    
    @PutMapping("/{id}/aplicar")
    public SolicitudCarga aplicarASolicitud(@PathVariable String id, @RequestParam String propietarioId) {
        return solicitudCargaService.aplicarASolicitud(id, propietarioId);
    }
    
    @PutMapping("/{id}/asignar")
    public SolicitudCarga asignarSolicitud(@PathVariable String id, @RequestParam String propietarioId) {
        return solicitudCargaService.asignarSolicitud(id, propietarioId);
    }
}
