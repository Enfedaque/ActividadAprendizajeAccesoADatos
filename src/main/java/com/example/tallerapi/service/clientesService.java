package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;

import java.util.List;

public interface clientesService {

    List<clientes> findAll();
    void cambiarEmail(String email);
    clientes findById(long id);
    clientes deleteCliente(long id);
    clientes addCliente(clientesDTO cliente);
    clientes modifyCliente(clientesDTO clienteDTO, long id);
}