/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backend.cargaexpress.repositories;

import com.backend.cargaexpress.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USER
 */

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}
