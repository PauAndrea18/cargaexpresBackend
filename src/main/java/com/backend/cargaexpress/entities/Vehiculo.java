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
@Document(collection = "vehiculos")
@Data
public class Vehiculo {
    @Id
    private String id;
    private String placa;
    private String marca;
    private String modelo;
    private double capacidadCarga;
    private String tipoCarroceria;
    private boolean disponible;
}

