package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.excepciones.*;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class facturasController {

    @Autowired
    private com.enfedaque.tallerapi.service.facturasService facturasService;

    @GetMapping("/Facturas") //Forma de buscarlo en el navegador
    public List<facturasDTO> getFacturas(){
        List<facturasDTO> factura=facturasService.findAll();
        return factura;
    }

    @PostMapping("/Facturas")
    public facturas addFactura(@RequestBody facturasDTO facturasDTO) throws vehiculoNotFoundException {
        facturas miFactura= facturasService.addFactura(facturasDTO);
        return miFactura;
    }

    @DeleteMapping("/Facturas/{FacturaId}")
    public facturas deleteFactura(@PathVariable long id) throws facturasNotFoundException {
        facturas miFactura= facturasService.deleteFactura(id);
        return miFactura;
    }

    @PutMapping("/Facturas/{FacturaId}")
    public facturas modifyFactura(@RequestBody facturasDTO facturaDTO, @PathVariable long id)
            throws usuarioNotFoundException, facturasNotFoundException {
        facturas miFactura= facturasService.modifyFactura(facturaDTO, id);
        return miFactura;
    }

    @GetMapping("/Facturas/{FacturaId}")
    public facturas getFactura(@PathVariable long id) throws facturasNotFoundException {
        facturas miFactura=facturasService.findById(id);
        return miFactura;
    }

    /*
    TODO
    AQUI GESTIONO LAS EXCEPCIONES Y LAS CAPTURO
     */
    @ExceptionHandler(facturasNotFoundException.class)
    public ResponseEntity<respuestaErrores> HandlerFacturaNoEncontrado(facturasNotFoundException fnfe){
        respuestaErrores miRespuestaErrores=new respuestaErrores("404", fnfe.getMessage());
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.NOT_FOUND);
    }

    //Gestor de excepciones generico para fallos que no tenga pensados
    @ExceptionHandler
    public ResponseEntity<respuestaErrores> excepcionGenerica(Exception exception){
        respuestaErrores miRespuestaErrores=new respuestaErrores("x", "Error en el lado servidor");
        return new ResponseEntity<>(miRespuestaErrores, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
