/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.entities;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author User
 */

@Document(collection = "reportes")
@Data
public class ReporteUbicacion {
    @Id
    private String id;
    private String remisionId;
    private LocalDateTime fechaHoraReporte;
    private String ubicacionActual;
    private String novedad;
    private double distanciaRecorrida;
}
