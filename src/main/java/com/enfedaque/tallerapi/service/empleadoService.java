package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.empleados;
import com.enfedaque.tallerapi.excepciones.empleadoNotFoundException;

import java.util.List;

public interface empleadoService {

    empleados addEmpleado(empleados empleado);
    empleados deleteEmpleado(long id) throws empleadoNotFoundException;
    empleados modifyEmpleado(empleados empleado, long id) throws empleadoNotFoundException;
    List<empleados> findAll();
    empleados findById(long id) throws empleadoNotFoundException;

    List<empleados> findByPuestoAndDepartamentoAndSalario(String puesto, String departamento, float salario);

    empleados modifySalario(float salario, long id) throws empleadoNotFoundException;
}
