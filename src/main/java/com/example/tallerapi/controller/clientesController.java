package com.example.tallerapi.controller;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import com.example.tallerapi.excepciones.usuarioNotFoundException;
import com.example.tallerapi.service.clientesService;
import com.example.tallerapi.service.vehiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class clientesController {

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private clientesService miClienteService;
    @Autowired
    private vehiculosService vehiculosService;

    //AÑADIR nuevo cliente
    //TODO ¡¡Este ya esta terminado y perfecto en teoria!!!
    @PostMapping("/Clientes")
    public clientes addCliente(@RequestBody clientesDTO clienteDTO){
        clientes miCliente= miClienteService.addCliente(clienteDTO);
        return miCliente;
    }

    //BORRAR cliente
    @DeleteMapping("/Clientes/{ClienteId}")
    public clientes deleteCliente(@PathVariable long id){
        clientes miCliente= miClienteService.deleteCliente(id);
        return miCliente;
    }

    //MODIFICAR un cliente por el id
    //TODO hacerlo con DTOs y mapeos
    @PutMapping("/Clientes/{ClientesId}")
    public clientes modifyCliente(@RequestBody clientesDTO clienteDTO, @PathVariable long id)
            throws usuarioNotFoundException {
        clientes miCliente= miClienteService.modifyCliente(clienteDTO, id);
        return miCliente;
    }

    //Metodo que me devuelva el TOTAL DE CLIENTES
    //TODO hacerlo con DTOs y mapeos
    @GetMapping("/Clientes") //Forma de buscarlo en el navegador
    public List<clientes> getClientes(){
        List<clientes> clientes=miClienteService.findAll();
        return clientes;
    }

    //Metodo que me devuelve un CLIENTE SEGUN ID
    //TODO hacerlo con DTOs y mapeos
    @GetMapping("/Clientes/{ClienteId}")
    public clientes getCliente(@PathVariable long id){
        clientes miCliente=miClienteService.findById(id);
        return miCliente;
    }
}
