package com.enfedaque.tallerapi.service;


import com.enfedaque.tallerapi.domain.dto.vehiculosDTO;
import com.enfedaque.tallerapi.domain.clientes;

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

import java.util.List;

@Service
public class vehiculosServiceImplem implements vehiculosService{

    @Autowired
    private vehiculosRepository vehiculosRepository;
    @Autowired
    private clientesRepository clientesRepository;
    @Autowired
    private facturasRepository facturasRepository;


    @Override
    public vehiculos addVehiculos(vehiculosDTO vehiculoDTO) throws clienteNotFoundException, facturasNotFoundException {
        clientes miCliente=clientesRepository.findById(vehiculoDTO.getCliente_id())
                .orElseThrow(clienteNotFoundException::new);

        ModelMapper mapper=new ModelMapper();

        vehiculos vehiculoNuevo=mapper.map(vehiculoDTO, vehiculos.class);
        vehiculoNuevo.setCliente(miCliente);
        return vehiculosRepository.save(vehiculoNuevo);
    }


    @Override
    public List<vehiculos> findAll() {
        List<vehiculos> listado=vehiculosRepository.findAll();

        return listado;
    }


    @Override
    public vehiculos deleteVehiculos(long id) throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosRepository.findById(id)
                .orElseThrow(vehiculoNotFoundException::new);

        vehiculosRepository.deleteById(id);

        return miVehiculo;
    }

    //TODO creo casi seguro que esta mal
    @Override
    public vehiculos modifyVehiculos(vehiculosDTO vehiculoDTO, long id) throws vehiculoNotFoundException, clienteNotFoundException {
        vehiculos miVehiculo= vehiculosRepository.findById(id)
                .orElseThrow(vehiculoNotFoundException::new);

        clientes miCliente=clientesRepository.findById(vehiculoDTO.getCliente_id())
                .orElseThrow(clienteNotFoundException::new);

        ModelMapper mapper= new ModelMapper();
        vehiculos miVehiculo2=mapper.map(vehiculoDTO, miVehiculo.getClass());

        miVehiculo2.setVehiculosID(miVehiculo.getVehiculosID());
        return vehiculosRepository.save(miVehiculo2);
    }

    @Override
    public vehiculos findById(long id) throws vehiculoNotFoundException{
        vehiculos miVehiculo=vehiculosRepository.findById(id)
                .orElseThrow(vehiculoNotFoundException::new);

        return miVehiculo;
    }

    @Override
    public List<vehiculos> findByMatriculaAndKilometrosAndAntiguedad(String matricula, float kilometros, int antiguedad) {

        List<vehiculos> mivehiculo=vehiculosRepository.findByMatriculaAndKilometrosAndAntiguedad(matricula, kilometros, antiguedad);

        return mivehiculo;
    }
}
