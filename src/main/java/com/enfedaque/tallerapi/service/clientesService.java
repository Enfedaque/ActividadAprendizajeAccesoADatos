package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;

import java.util.List;

public interface clientesService {

    List<clientes> findAll();
    clientesDTO findById(long id) throws clienteNotFoundException;
    clientes deleteCliente(long id) throws clienteNotFoundException;
    clientes addCliente(clientesDTO clienteDTO) throws vehiculoNotFoundException;
    clientes modifyCliente(clientesDTO clienteDTO, long id) throws clienteNotFoundException;
    clientes changeParameters(clientesDTO clienteDTO, long id) throws clienteNotFoundException;
}
