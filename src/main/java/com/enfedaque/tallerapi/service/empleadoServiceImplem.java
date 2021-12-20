package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.excepciones.empleadoNotFoundException;
import com.enfedaque.tallerapi.repository.empleadosRepository;
import com.enfedaque.tallerapi.domain.empleados;
import org.modelmapper.ModelMapper;
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
    public empleados modifyEmpleado(empleados empleado, long id) throws empleadoNotFoundException {
        empleados miEmpleado= miEmpleadoRepository.findById( id)
                .orElseThrow(empleadoNotFoundException::new);
        miEmpleado.setId(miEmpleado.getId());
        miEmpleado.setNombre(empleado.getNombre());
        miEmpleado.setApellido(empleado.getApellido());
        miEmpleado.setEmail(empleado.getEmail());
        miEmpleado.setTelefono(empleado.getTelefono());
        miEmpleado.setFechaNac(empleado.getFechaNac());
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
    public empleados findById(long id) throws empleadoNotFoundException {

        return miEmpleadoRepository.findById(id)
                .orElseThrow(() -> new empleadoNotFoundException());
    }

    @Override
    public empleados deleteEmpleado(long id) throws empleadoNotFoundException {
        empleados empleado=miEmpleadoRepository.findById(id)
                .orElseThrow(() -> new empleadoNotFoundException());
        miEmpleadoRepository.deleteById(id);
        return empleado;
    }
}
