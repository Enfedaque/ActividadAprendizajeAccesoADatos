package com.example.tallerapi.service;

import com.example.tallerapi.domain.dto.vehiculosDTO;
import com.example.tallerapi.domain.vehiculos;

import java.util.List;

public interface vehiculosService {

    List<vehiculos> findAll();
    vehiculos deleteVehiculos(long id);
    vehiculos modifyVehiculos(vehiculos vehiculos, long id);
    vehiculos addVehiculos(vehiculosDTO vehiculosDTO);
    vehiculos findById(long id);
}
