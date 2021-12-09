package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.repository.empleadosRepository;
import com.enfedaque.tallerapi.domain.empleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class empleadoServiceImplem implements empleadoService {

    @Autowired
    private empleadosRepository miEmpleadoRepository;


    @Override
    public empleados addEmpleado(empleados empleado) {
        return miEmpleadoRepository.save(empleado);
    }

    @Override
    public empleados modifyEmpleado(empleados empleado, long id) {
        empleados miEmpleado= miEmpleadoRepository.findById( id);
        miEmpleado.setPuesto(empleado.getPuesto());
        miEmpleado.setDepartamento(empleado.getDepartamento());
        miEmpleado.setSalario(empleado.getSalario());
        miEmpleado.setOperariosAlCargo(empleado.getOperariosAlCargo());
        miEmpleado.isJefeDeTaller(empleado.isJefeDeTaller());
        miEmpleado.setFechaComienzo(empleado.getFechaComienzo());
        return miEmpleadoRepository.save(miEmpleado);
    }

    @Override
    public List<empleados> findAll() {
        return miEmpleadoRepository.findAll();
    }

    @Override
    public empleados findById(long id) {
        return miEmpleadoRepository.findById(id);
    }

    @Override
    public empleados deleteEmpleado(long id) {
        empleados empleado=miEmpleadoRepository.findById(id);
        miEmpleadoRepository.deleteById(id);
        return empleado;
    }
}
