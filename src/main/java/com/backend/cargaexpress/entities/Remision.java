/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author USER
 */

@Document(collection = "remisiones")
@Data
public class Remision {
    @Id
    private String id;
    private String solicitudId;
    private LocalDateTime fechaHoraRecogida;
    private String origen;
    private String destino;
    private String placaCamion;
    private String conductorId;
    private String ruta;
    private String estado; // "EN_RUTA", "ENTREGADO", "COMPLETADO"
    private String valoracion;
    private LocalDateTime fechaHoraEntrega;
    private double pesoTotal;
}
