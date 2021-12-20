package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.repository.clientesRepository;
import com.enfedaque.tallerapi.repository.vehiculosRepository;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.domain.vehiculos;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

import java.util.List;

@Service
public class clientesServiceImplem implements clientesService{

    @Autowired
    private clientesRepository miClienteRepository;
    @Autowired
    private vehiculosRepository miVehiculosRepository;


    @Override
    public List<clientes> findAll() {
        List<clientes> listado=miClienteRepository.findAll();
        return listado;
    }


    @Override
    public clientesDTO findById(long id) throws clienteNotFoundException {
        clientes miCliente=miClienteRepository.findById(id)
                .orElseThrow(clienteNotFoundException::new);

        ModelMapper mapper=new ModelMapper();
        clientesDTO miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);
        return miClienteFinal;
    }


    @Override
    public clientes deleteCliente(long id) throws clienteNotFoundException {
        clientes miCliente= miClienteRepository.findById(id)
                .orElseThrow(clienteNotFoundException::new);
        miClienteRepository.deleteById(id);
        //ModelMapper mapper=new ModelMapper();
        //clientes miClienteFinal=mapper.map(miCliente, (Type) clientesDTO.class);
        return miCliente;
    }

    @Override
    public clientes addCliente(clientesDTO clienteDTO) {

        ModelMapper mapper=new ModelMapper();

        clientes miCliente=mapper.map(clienteDTO, clientes.class);

        return miClienteRepository.save(miCliente);
    }

    @Override
    public clientes modifyCliente(clientesDTO clienteDTO, long id) throws clienteNotFoundException {

        clientes miCliente= miClienteRepository.findById(id)
                .orElseThrow(clienteNotFoundException::new);

        ModelMapper mapper= new ModelMapper();
        clientes miCliente2=mapper.map(clienteDTO, miCliente.getClass());
        miCliente2.setId(miCliente.getId());
        return miClienteRepository.save(miCliente2);
    }

    @Override
    public clientes changeParameters(clientesDTO clienteDTO, long id) throws clienteNotFoundException {
        clientes miCliente=miClienteRepository.findById(id)
                .orElseThrow(clienteNotFoundException::new);


        return null;
    }
}
