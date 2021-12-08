package com.example.tallerapi.repository;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.vehiculos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface vehiculosRepository extends CrudRepository<vehiculos, Long> {

    vehiculos findById(long id);
}
