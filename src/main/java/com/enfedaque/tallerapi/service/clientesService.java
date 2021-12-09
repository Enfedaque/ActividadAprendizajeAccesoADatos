package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;

import java.util.List;

public interface clientesService {

    List<clientesDTO> findAll();
    clientesDTO findById(long id) throws clienteNotFoundException;
    clientes deleteCliente(long id) throws clienteNotFoundException;
    clientes addCliente(clientesDTO clienteDTO);
    clientes modifyCliente(clientesDTO clienteDTO, long id) throws clienteNotFoundException;
}
