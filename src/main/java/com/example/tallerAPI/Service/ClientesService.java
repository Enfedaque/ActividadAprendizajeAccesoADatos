package com.example.tallerAPI.Service;

import com.example.tallerAPI.Domain.Clientes;
import com.example.tallerAPI.Domain.Usuarios;

import java.util.List;

public interface ClientesService {

    List<Clientes> findAll();
    void cambiarEmail(String email);
    Clientes findById(long id);
    Clientes deleteCliente(long id);
    Clientes addCliente(Clientes cliente);
    Clientes modifyCliente(Clientes cliente, long id);
}
