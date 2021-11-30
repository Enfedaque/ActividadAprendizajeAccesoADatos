package com.example.tallerAPI.Service;

import com.example.tallerAPI.Domain.Usuarios;

import java.util.List;

public interface UsuariosService {

    /*METODOS QUE QUIERO QUE TENGA MI SERVICIO WEB
    Es la parte logica de la aplicacion
     */

    List<Usuarios> findAll();
    void cambiarEmail(String email);
    Usuarios findById(long id);
    Usuarios deleteUsuario(long id);
    Usuarios addUsuario(Usuarios usuario);
    Usuarios modifyUsuario(Usuarios usuario, long id);
}
