package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.dto.vehiculosDTO;
import com.enfedaque.tallerapi.domain.vehiculos;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.service.clientesService;
import com.enfedaque.tallerapi.service.vehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class vehiculosController {

    @Autowired
    private clientesService clientesService;
    @Autowired
    private vehiculosService vehiculosService;

    //AÑADIR nuevo vehiculo
    //TODO ¡¡Este ya esta terminado y perfecto en teoria!!!
    @PostMapping("/Vehiculos")
    public vehiculos addVehiculo(@RequestBody vehiculosDTO vehiculosDTO) throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosService.addVehiculos(vehiculosDTO);
        return miVehiculo;
    }

    //BORRAR vehiculo
    //TODO Terminado, sin probar
    @DeleteMapping("/Vehiculos/{VehiculoId}")
    public vehiculos deleteVehiculo(@PathVariable long id) throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosService.deleteVehiculos(id);
        return miVehiculo;
    }

    //MODIFICAR un vehiculo por el id
    //TODO Terminado, sin probar
    @PutMapping("/Vehiculos/{VehiculoId}")
    public vehiculos modifyVehiculo(@RequestBody vehiculosDTO vehiculosDTO, @PathVariable long id)
            throws vehiculoNotFoundException {
        vehiculos miVehiculo= vehiculosService.modifyVehiculos(vehiculosDTO, id);
        return miVehiculo;
    }

    //Metodo que me devuelva el TOTAL DE vehiculos
    //TODO Terminado, sin probar
    @GetMapping("/Vehiculos") //Forma de buscarlo en el navegador
    public List<vehiculosDTO> getVehiculos(){
        List<vehiculosDTO> vehiculos=vehiculosService.findAll();
        return vehiculos;
    }

    //Metodo que me devuelve un VEHICULO SEGUN ID
    //TODO Terminado, sin probar
    @GetMapping("/Vehiculos/{VehiculoId}")
    public vehiculos getVehiculo(@PathVariable long id) throws vehiculoNotFoundException {
        vehiculos miVehiculo=vehiculosService.findById(id);
        return miVehiculo;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(vehiculoNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerVehiculoNoEncontrado(vehiculoNotFoundException vnfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", vnfe.getMessage());
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
