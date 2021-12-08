package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;

import java.util.List;

public interface clientesService {

    List<clientes> findAll();
    clientes findById(long id);
    clientes deleteCliente(long id);
    clientes addCliente(clientesDTO clienteDTO);
    clientes modifyCliente(clientes cliente, long id);
}
