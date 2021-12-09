package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.usuarios;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;

import java.util.List;

public interface usuariosService {

    /*METODOS QUE QUIERO QUE TENGA MI SERVICIO WEB
    Es la parte logica de la aplicacion
     */

    List<usuarios> findAll();
    usuarios findById(long id) throws usuarioNotFoundException;
    usuarios deleteUsuario(long id) throws usuarioNotFoundException;
    usuarios addUsuario(usuarios usuario);
    usuarios modifyUsuario(usuarios usuario, long id) throws usuarioNotFoundException;
}
