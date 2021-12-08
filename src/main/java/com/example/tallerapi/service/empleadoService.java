package com.example.tallerapi.service;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.empleados;

import java.util.List;

public interface empleadoService {

    empleados addEmpleado(empleados empleado);
    empleados deleteEmpleado(long id);
    empleados modifyEmpleado(empleados empleado, long id);
    List<empleados> findAll();
    empleados findById(long id);
}
