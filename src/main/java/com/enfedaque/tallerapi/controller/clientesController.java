package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.dto.clientesDTO;
import com.enfedaque.tallerapi.domain.clientes;
import com.enfedaque.tallerapi.excepciones.clienteNotFoundException;
import com.enfedaque.tallerapi.excepciones.respuestaErrores;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.service.clientesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class clientesController {

    private final Logger logger = LoggerFactory.getLogger(clientesController.class);

    @Autowired //Spring lo inicializa y hace todas las cosas sin tener que hacer el new
    private clientesService miClienteService;
    @Autowired
    private com.enfedaque.tallerapi.service.vehiculosService vehiculosService;

    //AÑADIR nuevo cliente
    //TODO ¡¡Este ya esta terminado y perfecto en teoria!!!
    @PostMapping("/Clientes")
    public clientes addCliente(@RequestBody clientesDTO clienteDTO) throws vehiculoNotFoundException {
        logger.info("Inicio AddCliente");
        clientes miCliente= miClienteService.addCliente(clienteDTO);
        logger.info("Fin AddCliente. Cliente añadido");
        return miCliente;
    }

    //BORRAR cliente
    //TODO Terminado, sin probar
    @DeleteMapping("/Clientes/{id}")
    public clientes deleteCliente(@PathVariable long id) throws clienteNotFoundException {
        logger.info("Inicio deleteCliente");
        clientes miCliente= miClienteService.deleteCliente(id);
        logger.info("Cliente con id: " + miCliente.getId() + " eliminado. FIN de la operación");
        return miCliente;
    }

    //MODIFICAR un cliente por el id
    //TODO Terminado, sin probar
    @PutMapping("/Clientes/{id}")
    public clientes modifyCliente(@RequestBody clientesDTO clientesDTO, @PathVariable long id)
            throws clienteNotFoundException {
        logger.info("Inicio modificar cliente con id: " + id);
        clientes miCliente= miClienteService.modifyCliente(clientesDTO, id);
        logger.info("Cliente con id: " + miCliente.getId() + " modificado. FIN de la operación");
        return miCliente;
    }

    //Metodo que me devuelva el TOTAL DE CLIENTES
    //TODO Terminado, sin probar
    @GetMapping("/Clientes") //Forma de buscarlo en el navegador
    public List<clientes> getClientes(){
        logger.info("Inicio getClientes");
        List<clientes> clientes=miClienteService.findAll();
        logger.info("Fin operacion de mostrado de clientes");
        return clientes;
    }

    //Metodo que me devuelve un CLIENTE SEGUN ID
    //TODO Terminado, sin probar
    @GetMapping("/Clientes/{id}")
    public clientesDTO getCliente(@PathVariable long id) throws clienteNotFoundException {
        logger.info("Inicio busqueda de cliente con id: " + id);
        clientesDTO miCliente=miClienteService.findById(id);
        logger.info("Fin de la operacion de busqueda");
        return miCliente;
    }

    //Metodo que modifica solo 1 parametro
    //TODO terminado sin probar
    @PatchMapping("/Clientes/{id}")
    public clientes changeParameters(@RequestBody clientesDTO clientesDTO, @PathVariable long id) throws clienteNotFoundException {
        logger.info("Inicio modificacion de cliente con id: " + id);
        clientes miCliente=miClienteService.changeParameters(clientesDTO, id);
        logger.info("Cliente con id: " + id + " modificado. FIN de la operación");
        return miCliente;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(clienteNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerClienteNoEncontrado(clienteNotFoundException cnfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", cnfe.getMessage());
        logger.error(cnfe.getMessage(), cnfe);
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        logger.error(exception.getMessage(), exception);
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
