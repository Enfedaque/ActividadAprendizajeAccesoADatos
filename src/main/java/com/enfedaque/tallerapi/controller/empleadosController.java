package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.empleados;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.service.empleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class empleadosController {

    @Autowired
    private empleadoService miEmpleadoService;

    //AÑADIR nuevo empleado
    @PostMapping("/Empleados")
    public empleados addEmpleado(@RequestBody empleados empleado){
        empleados miEmpleado= miEmpleadoService.addEmpleado(empleado);
        return miEmpleado;
    }

    //BORRAR cliente
    @DeleteMapping("/Empleados/{EmpleadoId}")
    public empleados deleteEmpleado(@PathVariable long id){
        empleados miEmpleado= miEmpleadoService.deleteEmpleado(id);
        return miEmpleado;
    }

    //MODIFICAR un cliente por el id
    @PutMapping("/Empleados/{EmpleadoId}")
    public empleados modifyEmpleado(@RequestBody empleados empleado, @PathVariable long id)
            throws usuarioNotFoundException {
        empleados empleados=miEmpleadoService.modifyEmpleado(empleado, id);
        return empleados;
    }

    //Metodo que me devuelva el TOTAL DE EMPLEADOS
    @GetMapping("/Empleados") //Forma de buscarlo en el navegador
    public List<empleados> getempleados(){
        List<empleados> empleados=miEmpleadoService.findAll();
        return empleados;
    }

    //Metodo que me devuelve un EMPLEADO SEGUN ID
    @GetMapping("/Empleados/{EmpleadoId}")
    public empleados getEmpleado(@PathVariable long id){
        empleados miEmpleado=miEmpleadoService.findById(id);
        return miEmpleado;
    }
}
