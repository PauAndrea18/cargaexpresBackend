/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author USER
 */

@Document(collection = "solicitudes")
@Data
public class SolicitudCarga {
    @Id
    private String id;
    private LocalDate fecha;
    private String propietarioCargaId;
    private String origen;
    private String destino;
    private double dimensiones;
    private double peso;
    private double valorAsegurado;
    private String empaque;
    private String estado; // "PENDIENTE", "ASIGNADA", "CANCELADA"
    private String propietarioAsignadoId;
    private List<String> propietariosInteresados;
}

