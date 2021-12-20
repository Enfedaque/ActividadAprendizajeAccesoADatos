package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.excepciones.*;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class facturasController {

    private final Logger logger = LoggerFactory.getLogger(facturasController.class);

    @Autowired
    private com.enfedaque.tallerapi.service.facturasService facturasService;

    @GetMapping("/Facturas") //Forma de buscarlo en el navegador
    public List<facturasDTO> getFacturas(){
        logger.info("Inicio getFacturas");
        List<facturasDTO> factura=facturasService.findAll();
        logger.info("Fin operacion de mostrado de facturas");
        return factura;
    }

    @PostMapping("/Facturas")
    public facturas addFactura(@RequestBody facturasDTO facturasDTO) throws vehiculoNotFoundException {
        logger.info("Inicio AddFactura");
        facturas miFactura= facturasService.addFactura(facturasDTO);
        logger.info("Factura con id: " + miFactura.getNumFactura() + " añadida. FIN de la operación");
        return miFactura;
    }

    @DeleteMapping("/Facturas/{id}")
    public facturas deleteFactura(@PathVariable long id) throws facturasNotFoundException {
        logger.info("Inicio deleteFactura");
        facturas miFactura= facturasService.deleteFactura(id);
        logger.info("Factura con id: " + miFactura.getNumFactura() + " eliminada. FIN de la operación");
        return miFactura;
    }

    @PutMapping("/Facturas/{id}")
    public facturas modifyFactura(@RequestBody facturasDTO facturaDTO, @PathVariable long id)
            throws usuarioNotFoundException, facturasNotFoundException, vehiculoNotFoundException {
        logger.info("Inicio modificar factura con id: " + id);
        facturas miFactura= facturasService.modifyFactura(facturaDTO, id);
        logger.info("Factura con id: " + miFactura.getNumFactura() + " modificada. FIN de la operación");
        return miFactura;
    }

    @GetMapping("/Facturas/{id}")
    public facturas getFactura(@PathVariable long id) throws facturasNotFoundException {
        logger.info("Inicio busqueda de factura con id: " + id);
        facturas miFactura=facturasService.findById(id);
        logger.info("Fin de la operacion de busqueda");
        return miFactura;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(facturasNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerFacturaNoEncontrado(facturasNotFoundException fnfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", fnfe.getMessage());
        logger.error(fnfe.getMessage(), fnfe);
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
