package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.clientes;

import java.util.List;

public interface clientesService {

    List<clientesDTO> findAll();
    clientesDTO findById(long id);
    clientes deleteCliente(long id);
    clientes addCliente(clientesDTO clienteDTO);
    clientes modifyCliente(clientesDTO clienteDTO, long id);
}
