package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.vehiculosDTO;
import com.enfedaque.tallerapi.domain.vehiculos;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;

import java.util.List;

public interface vehiculosService {

    List<vehiculosDTO> findAll();
    vehiculos deleteVehiculos(long id) throws vehiculoNotFoundException;
    vehiculos modifyVehiculos(vehiculosDTO vehiculosDTO, long id) throws vehiculoNotFoundException;
    vehiculos addVehiculos(vehiculosDTO vehiculosDTO) throws vehiculoNotFoundException;
    vehiculos findById(long id) throws vehiculoNotFoundException;
}
