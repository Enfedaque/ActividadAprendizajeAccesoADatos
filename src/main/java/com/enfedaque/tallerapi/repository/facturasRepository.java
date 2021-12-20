package com.enfedaque.tallerapi.repository;

import com.enfedaque.tallerapi.domain.facturas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface facturasRepository extends CrudRepository<facturas, Long> {

    List<facturas> findAll();

    List<facturas> findByNombrePropietarioAndIsEmpresaAndPrecio(String nombrePropietario, boolean isEmpresa, float precio);
}
