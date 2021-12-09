package com.enfedaque.tallerapi.controller;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.excepciones.usuarioNotFoundException;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public facturas addFactura(@RequestBody facturasDTO facturasDTO){
        facturas miFactura= facturasService.addFactura(facturasDTO);
        return miFactura;
    }

    @DeleteMapping("/Facturas/{FacturaId}")
    public facturas deleteFactura(@PathVariable long id){
        facturas miFactura= facturasService.deleteFactura(id);
        return miFactura;
    }

    @PutMapping("/Facturas/{FacturaId}")
    public facturas modifyFactura(@RequestBody facturasDTO facturaDTO, @PathVariable long id)
            throws usuarioNotFoundException {
        facturas miFactura= facturasService.modifyFactura(facturaDTO, id);
        return miFactura;
    }

    @GetMapping("/Facturas/{FacturaId}")
    public facturas getFactura(@PathVariable long id){
        facturas miFactura=facturasService.findById(id);
        return miFactura;
    }
}
