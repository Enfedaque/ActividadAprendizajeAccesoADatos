package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;
import com.enfedaque.tallerapi.excepciones.facturasNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;

import java.util.List;

public interface facturasService {

    List<facturasDTO> findAll();
    facturas findById(long id) throws facturasNotFoundException;
    facturas deleteFactura(long id) throws facturasNotFoundException;
    facturas addFactura(facturasDTO facturasDTO) throws vehiculoNotFoundException;
    facturas modifyFactura(facturasDTO facturasDTO, long id) throws facturasNotFoundException, vehiculoNotFoundException;
}
