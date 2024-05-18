/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;


/**
 *
 * @author USER
 */
import java.util.List;

@Document(collection = "rutas")
@Data
public class RutaEnvio {
    @Id
    private String id;
    private String solicitudId;
    private List<String> puntos;
}

