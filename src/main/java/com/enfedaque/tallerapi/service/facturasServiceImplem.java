package com.enfedaque.tallerapi.service;

import com.enfedaque.tallerapi.domain.facturas;
import com.enfedaque.tallerapi.domain.dto.facturasDTO;
import com.enfedaque.tallerapi.domain.vehiculos;
import com.enfedaque.tallerapi.excepciones.facturasNotFoundException;
import com.enfedaque.tallerapi.excepciones.vehiculoNotFoundException;
import com.enfedaque.tallerapi.repository.facturasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class facturasServiceImplem implements facturasService {

    @Autowired
    private facturasRepository facturasRepository;
    @Autowired
    private com.enfedaque.tallerapi.repository.vehiculosRepository vehiculosRepository;

    @Override
    public List<facturasDTO> findAll() {
        List<facturas> listado=facturasRepository.findAll();
        ModelMapper mapper=new ModelMapper();
        List<facturasDTO> listadoFinal=mapper.map(listado, (Type) facturasDTO.class);
        return listadoFinal;
    }

    @Override
    public facturas findById(long id) throws facturasNotFoundException {
        facturas miFactura=facturasRepository.findById(id)
                .orElseThrow(() -> new facturasNotFoundException());
        ModelMapper mapper=new ModelMapper();
        facturas miFacturaFInal=mapper.map(miFactura, (Type) facturasDTO.class);
        return miFacturaFInal;
    }

    @Override
    public facturas deleteFactura(long id) throws facturasNotFoundException {
        facturas miFactura= facturasRepository.findById(id)
                .orElseThrow(() -> new facturasNotFoundException());
        facturasRepository.deleteById(id);
        ModelMapper mapper=new ModelMapper();
        facturas miFacturaFinal=mapper.map(miFactura, (Type) facturasDTO.class);
        return miFacturaFinal;
    }

    @Override
    public facturas addFactura(facturasDTO facturasDTO) throws vehiculoNotFoundException {
        vehiculos vehiculo=vehiculosRepository.findById((long) facturasDTO.getIdentificador())
                .orElseThrow(() -> new vehiculoNotFoundException());
        ModelMapper mapper=new ModelMapper();
        facturas facturaFInal=mapper.map(facturasDTO, facturas.class);
        facturaFInal.setVehiculo(vehiculo);
        return facturasRepository.save(facturaFInal);
    }

    //TODO creo casi seguro que esta mal
    @Override
    public facturas modifyFactura(facturasDTO facturasDTO, long id) throws facturasNotFoundException {
        facturas miFactura= facturasRepository.findById(id)
                .orElseThrow(() -> new facturasNotFoundException());
        ModelMapper mapper= new ModelMapper();
        facturas miFacturaFinal=mapper.map(facturasDTO, miFactura.getClass());
        return miFacturaFinal;
    }
}
