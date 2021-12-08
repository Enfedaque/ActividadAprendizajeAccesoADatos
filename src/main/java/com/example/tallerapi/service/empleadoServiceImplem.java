package com.example.tallerapi.service;

import com.example.tallerapi.domain.empleados;
import com.example.tallerapi.repository.empleadosRepository;
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
        //TODO POR HACER TODAVIA
        return null;
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
