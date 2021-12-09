package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;

import java.util.List;

public interface facturasService {

    List<facturasDTO> findAll();
    facturas findById(long id);
    facturas deleteFactura(long id);
    facturas addFactura(facturasDTO facturasDTO);
    facturas modifyFactura(facturasDTO facturasDTO, long id);
}
