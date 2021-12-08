package com.example.tallerapi.service;

import com.example.tallerapi.domain.usuarios;
import com.example.tallerapi.excepciones.usuarioNotFoundException;

import java.util.List;

public interface usuariosService {

    /*METODOS QUE QUIERO QUE TENGA MI SERVICIO WEB
    Es la parte logica de la aplicacion
     */

    List<usuarios> findAll();
    void cambiarEmail(String email);
    usuarios findById(long id) throws usuarioNotFoundException;
    usuarios deleteUsuario(long id) throws usuarioNotFoundException;
    usuarios addUsuario(usuarios usuario);
    usuarios modifyUsuario(usuarios usuario, long id) throws usuarioNotFoundException;
}
