package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.empleados;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.empleadoNotFoundException;
import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.service.empleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public empleados deleteEmpleado(@PathVariable long id) throws empleadoNotFoundException {
        empleados miEmpleado= miEmpleadoService.deleteEmpleado(id);
        return miEmpleado;
    }

    //MODIFICAR un cliente por el id
    @PutMapping("/Empleados/{EmpleadoId}")
    public empleados modifyEmpleado(@RequestBody empleados empleado, @PathVariable long id)
            throws empleadoNotFoundException {
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
    public empleados getEmpleado(@PathVariable long id) throws empleadoNotFoundException {
        empleados miEmpleado=miEmpleadoService.findById(id);
        return miEmpleado;
    }


    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(empleadoNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerEmpleadoNoEncontrado(empleadoNotFoundException enfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", enfe.getMessage());
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
