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
import java.util.ArrayList;
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
        List<facturasDTO> lista= new ArrayList<>();
        List<facturasDTO> listadoFinal=mapper.map(listado, lista.getClass());
        return listadoFinal;
    }

    @Override
    public facturas findById(long id) throws facturasNotFoundException {
        facturas miFactura=facturasRepository.findById(id)
                .orElseThrow(facturasNotFoundException::new);

        return miFactura;
    }

    @Override
    public facturas deleteFactura(long id) throws facturasNotFoundException {
        facturas miFactura= facturasRepository.findById(id)
                .orElseThrow(facturasNotFoundException::new);

        facturasRepository.deleteById(id);

        return miFactura;
    }

    @Override
    public facturas addFactura(facturasDTO facturasDTO) throws vehiculoNotFoundException {
        vehiculos vehiculo=vehiculosRepository.findById(facturasDTO.getVehiculo())
                .orElseThrow(vehiculoNotFoundException::new);
        ModelMapper mapper=new ModelMapper();
        facturas facturaFInal=mapper.map(facturasDTO, facturas.class);
        facturaFInal.setVehiculo(vehiculo);
        return facturasRepository.save(facturaFInal);
    }

    //TODO creo casi seguro que esta mal
    @Override
    public facturas modifyFactura(facturasDTO facturasDTO, long id) throws facturasNotFoundException, vehiculoNotFoundException {
        facturas miFactura= facturasRepository.findById(id)
                .orElseThrow(facturasNotFoundException::new);
        vehiculos miVehiculo=vehiculosRepository.findById(facturasDTO.getVehiculo())
                .orElseThrow(vehiculoNotFoundException::new);

        ModelMapper mapper= new ModelMapper();
        facturas miFacturaFinal=mapper.map(facturasDTO, miFactura.getClass());
        miFacturaFinal.setNumFactura(miFactura.getNumFactura());

        return facturasRepository.save(miFacturaFinal);
    }

    @Override
    public List<facturas> findByNombrePropietarioAndIsEmpresaAndPrecio(String nombrePropietario, boolean isEmpresa, float precio) {

        List<facturas> miFactura=facturasRepository.findByNombrePropietarioAndIsEmpresaAndPrecio(nombrePropietario, isEmpresa, precio);

        return miFactura;
    }

    @Override
    public facturas modifyPrecio(float precio, long id) throws facturasNotFoundException{

        facturas miFactura=facturasRepository.findById(id)
                .orElseThrow(facturasNotFoundException::new);

        miFactura.setPrecio(precio);
        return facturasRepository.save(miFactura);
    }
}
