/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.controllers;

import com.backend.cargaexpress.entities.Remision;
import com.backend.cargaexpress.services.RemisionService;
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
@RequestMapping("/remisiones")
public class RemisionController {
    @Autowired
    private RemisionService remisionService;

    @PostMapping
    public Remision crearRemision(@RequestParam String solicitudId, @RequestParam String placaCamion,
                                  @RequestParam String conductorId, @RequestParam String ruta) {
        return remisionService.crearRemision(solicitudId, placaCamion, conductorId, ruta);
    }

    @PutMapping("/{id}")
    public Remision actualizarRemision(@PathVariable String id, @RequestBody Remision remision) {
        return remisionService.actualizarRemision(id, remision);
    }

    @DeleteMapping("/{id}")
    public void eliminarRemision(@PathVariable String id) {
        remisionService.eliminarRemision(id);
    }

    @GetMapping("/{id}")
    public Remision obtenerRemision(@PathVariable String id) {
        return remisionService.obtenerRemision(id);
    }

    @GetMapping
    public List<Remision> obtenerTodasLasRemisiones() {
        return remisionService.obtenerTodasLasRemisiones();
    }
    
    @PutMapping("/{id}/estado")
    public Remision actualizarEstadoRemision(@PathVariable String id, @RequestParam String estado) {
        return remisionService.actualizarEstadoRemision(id, estado);
    }
    
    @PutMapping("/{id}/cerrar")
    public Remision cerrarRemision(@PathVariable String id, @RequestParam String valoracion) {
        return remisionService.cerrarRemision(id, valoracion);
    }
}
