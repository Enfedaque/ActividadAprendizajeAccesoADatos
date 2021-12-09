package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.dto.vehiculosDTO;
import com.enfedaque.tallerapi.domain.vehiculos;

import java.util.List;

public interface vehiculosService {

    List<vehiculosDTO> findAll();
    vehiculos deleteVehiculos(long id);
    vehiculos modifyVehiculos(vehiculosDTO vehiculosDTO, long id);
    vehiculos addVehiculos(vehiculosDTO vehiculosDTO);
    vehiculos findById(long id);
}
