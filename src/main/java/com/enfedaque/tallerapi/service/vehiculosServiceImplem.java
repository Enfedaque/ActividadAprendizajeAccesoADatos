package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.dto.vehiculosDTO;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.domain.vehiculos;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.facturasNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.repository.clientesRepository;
import com.enfedaque.tallerapi.repository.facturasRepository;
import com.enfedaque.tallerapi.repository.vehiculosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class vehiculosServiceImplem implements vehiculosService{

    @Autowired
    private vehiculosRepository vehiculosRepository;
    @Autowired
    private clientesRepository clientesRepository;
    @Autowired
    private facturasRepository facturasRepository;

    //todo ---------------Falta probarlo --------------
    @Override
    public vehiculos addVehiculos(vehiculosDTO vehiculoDTO) throws clienteNotFoundException, facturasNotFoundException {
        clientes miCliente=clientesRepository.findById(vehiculoDTO.getCliente_id())
                .orElseThrow(clienteNotFoundException::new);

        ModelMapper mapper=new ModelMapper();

        vehiculos vehiculoNuevo=mapper.map(vehiculoDTO, vehiculos.class);
        vehiculoNuevo.setCliente(miCliente);
        return vehiculosRepository.save(vehiculoNuevo);
    }



    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public List<vehiculos> findAll() {
        List<vehiculos> listado=vehiculosRepository.findAll();
        //ModelMapper mapper=new ModelMapper();
        //List<vehiculosDTO> listadoFinal=mapper.map(listado, (Type) vehiculosDTO.class);
        return listado;
    }

    //TODO ---------------Falta probarlo --------------
    @Override
    public vehiculos deleteVehiculos(long id) throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosRepository.findById(id)
                .orElseThrow(vehiculoNotFoundException::new);

        vehiculosRepository.deleteById(id);

        return miVehiculo;
    }

    //TODO creo casi seguro que esta mal
    @Override
    public vehiculos modifyVehiculos(vehiculosDTO vehiculoDTO, long id) throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosRepository.findById(id)
                .orElseThrow(() -> new vehiculoNotFoundException());
        ModelMapper mapper= new ModelMapper();
        vehiculos miVehiculo2=mapper.map(vehiculoDTO, miVehiculo.getClass());
        return miVehiculo2;
    }

    //TODO ---------------Falta probarlo --------------
    @Override
    public vehiculos findById(long id) throws vehiculoNotFoundException{
        vehiculos miVehiculo=vehiculosRepository.findById(id)
                .orElseThrow(vehiculoNotFoundException::new);

        return miVehiculo;
    }
}
