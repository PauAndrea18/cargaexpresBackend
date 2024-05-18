/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.backend.cargaexpress.controllers;

import com.backend.cargaexpress.entities.RutaEnvio;
import com.backend.cargaexpress.services.RutaEnvioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/rutas")
public class RutaEnvioController {
    @Autowired
    private RutaEnvioService rutaEnvioService;

    @PostMapping
    public RutaEnvio crearRutaEnvio(@RequestBody RutaEnvio rutaEnvio) {
        return rutaEnvioService.crearRutaEnvio(rutaEnvio);
    }

    @PutMapping("/{id}")
    public RutaEnvio actualizarRutaEnvio(@PathVariable String id, @RequestBody RutaEnvio rutaEnvio) {
        return rutaEnvioService.actualizarRutaEnvio(id, rutaEnvio);
    }

    @DeleteMapping("/{id}")
    public void eliminarRutaEnvio(@PathVariable String id) {
        rutaEnvioService.eliminarRutaEnvio(id);
    }

    @GetMapping("/{id}")
    public RutaEnvio obtenerRutaEnvio(@PathVariable String id) {
        return rutaEnvioService.obtenerRutaEnvio(id);
    }

    @GetMapping
    public List<RutaEnvio> obtenerTodasLasRutasEnvio() {
        return rutaEnvioService.obtenerTodasLasRutasEnvio();
    }
}
