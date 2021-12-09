package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.service.clientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class clientesController {

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private clientesService miClienteService;
    @Autowired
    private com.enfedaque.tallerapi.service.vehiculosService vehiculosService;

    //AÑADIR nuevo cliente
    //TODO ¡¡Este ya esta terminado y perfecto en teoria!!!
    @PostMapping("/Clientes")
    public clientes addCliente(@RequestBody clientesDTO clienteDTO){
        clientes miCliente= miClienteService.addCliente(clienteDTO);
        return miCliente;
    }

    //BORRAR cliente
    //TODO Terminado, sin probar
    @DeleteMapping("/Clientes/{ClienteId}")
    public clientes deleteCliente(@PathVariable long id) throws clienteNotFoundException {
        clientes miCliente= miClienteService.deleteCliente(id);
        return miCliente;
    }

    //MODIFICAR un cliente por el id
    //TODO Terminado, sin probar
    @PutMapping("/Clientes/{ClientesId}")
    public clientes modifyCliente(@RequestBody clientesDTO clientesDTO, @PathVariable long id)
            throws clienteNotFoundException {
        clientes miCliente= miClienteService.modifyCliente(clientesDTO, id);
        return miCliente;
    }

    //Metodo que me devuelva el TOTAL DE CLIENTES
    //TODO Terminado, sin probar
    @GetMapping("/Clientes") //Forma de buscarlo en el navegador
    public List<clientesDTO> getClientes(){
        List<clientesDTO> clientes=miClienteService.findAll();
        return clientes;
    }

    //Metodo que me devuelve un CLIENTE SEGUN ID
    //TODO Terminado, sin probar
    @GetMapping("/Clientes/{ClienteId}")
    public clientesDTO getCliente(@PathVariable long id) throws clienteNotFoundException {
        clientesDTO miCliente=miClienteService.findById(id);
        return miCliente;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(clienteNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerClienteNoEncontrado(clienteNotFoundException cnfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", cnfe.getMessage());
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
