package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import com.example.tallerapi.domain.dto.vehiculosDTO;
import com.example.tallerapi.domain.vehiculos;
import com.example.tallerapi.repository.clientesRepository;
import com.example.tallerapi.repository.vehiculosRepository;
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

    //TODO ¡¡¡¡¡Esta perfecto este!!!!
    @Override
    public vehiculos addVehiculos(vehiculosDTO vehiculoDTO) {
        clientes miCliente=clientesRepository.findById(vehiculoDTO.getCliente_id());
        ModelMapper mapper=new ModelMapper();
        vehiculos vehiculoNuevo=mapper.map(vehiculoDTO, vehiculos.class);
        vehiculoNuevo.setCliente(miCliente);
        return vehiculosRepository.save(vehiculoNuevo);
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public List<vehiculos> findAll() {
        List<vehiculos> listado=vehiculosRepository.findAll();
        ModelMapper mapper=new ModelMapper();
        List<vehiculos> listadoFinal=mapper.map(listado, (Type) vehiculosDTO.class);
        return listadoFinal;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public vehiculos deleteVehiculos(long id) {
        vehiculos miVehiculo= vehiculosRepository.findById(id);
        vehiculosRepository.deleteById(id);
        ModelMapper mapper=new ModelMapper();
        vehiculos miVehiculoFinal=mapper.map(miVehiculo, (Type) vehiculosDTO.class);
        return miVehiculoFinal;
    }

    //TODO creo casi seguro que esta mal
    @Override
    public vehiculos modifyVehiculos(vehiculos vehiculo, long id) {
        vehiculos miVehiculo= vehiculosRepository.findById(id);
        ModelMapper mapper= new ModelMapper();
        vehiculos miVehiculo2=mapper.map(vehiculo, miVehiculo.getClass());
        return miVehiculo2;
    }

    //TODO ¡¡¡Creo que esta bien pero hay que probarlo!!!!
    @Override
    public vehiculos findById(long id) {
        vehiculos miVehiculo=vehiculosRepository.findById(id);
        ModelMapper mapper=new ModelMapper();
        vehiculos miVehiculoFinal=mapper.map(miVehiculo, (Type) clientesDTO.class);
        return miVehiculoFinal;
    }
}
