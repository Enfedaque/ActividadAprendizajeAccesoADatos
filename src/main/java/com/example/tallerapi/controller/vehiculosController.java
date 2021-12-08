package com.example.tallerapi.controller;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import com.example.tallerapi.domain.dto.vehiculosDTO;
import com.example.tallerapi.domain.vehiculos;
import com.example.tallerapi.excepciones.usuarioNotFoundException;
import com.example.tallerapi.service.clientesService;
import com.example.tallerapi.service.vehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public vehiculos addVehiculo(@RequestBody vehiculosDTO vehiculosDTO){
        vehiculos miVehiculo= vehiculosService.addVehiculos(vehiculosDTO);
        return miVehiculo;
    }

    //BORRAR vehiculo
    @DeleteMapping("/Vehiculos/{VehiculoId}")
    public vehiculos deleteVehiculo(@PathVariable long id){
        vehiculos miVehiculo= vehiculosService.deleteVehiculos(id);
        return miVehiculo;
    }

    //MODIFICAR un vehiculo por el id
    //TODO hacerlo con DTOs y mapeos
    @PutMapping("/Vehiculos/{VehiculoId}")
    public vehiculos modifyVehiculo(@RequestBody vehiculos vehiculo, @PathVariable long id)
            throws usuarioNotFoundException {
        vehiculos miVehiculo= vehiculosService.modifyVehiculos(vehiculo, id);
        return miVehiculo;
    }

    //Metodo que me devuelva el TOTAL DE vehiculos
    //TODO ¡¡terminado en teoria
    @GetMapping("/Vehiculos") //Forma de buscarlo en el navegador
    public List<vehiculos> getVehiculos(){
        List<vehiculos> vehiculos=vehiculosService.findAll();
        return vehiculos;
    }

    //Metodo que me devuelve un VEHICULO SEGUN ID
    //TODO hacerlo con DTOs y mapeos
    @GetMapping("/Vehiculos/{VehiculoId}")
    public vehiculos getVehiculo(@PathVariable long id){
        vehiculos miVehiculo=vehiculosService.findById(id);
        return miVehiculo;
    }
}
