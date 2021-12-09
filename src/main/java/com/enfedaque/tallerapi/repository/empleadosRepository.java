package com.enfedaque.tallerapi.repository;

import com.enfedaque.tallerapi.domain.empleados;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface empleadosRepository extends CrudRepository<empleados, Long> {

    empleados findById(long id);
    List<empleados> findAll();
}
