package com.example.tallerapi.service;

import com.example.tallerapi.domain.dto.vehiculosDTO;
import com.example.tallerapi.domain.vehiculos;
import com.example.tallerapi.repository.vehiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class vehiculosServiceImplem implements vehiculosService{

    @Autowired
    private vehiculosRepository vehiculosRepository;

    @Override
    public vehiculos addVehiculo(vehiculosDTO vehiculo) {
        return null;
    }
}
