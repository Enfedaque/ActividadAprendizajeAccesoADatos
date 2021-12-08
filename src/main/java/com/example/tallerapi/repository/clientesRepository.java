package com.example.tallerapi.repository;

import com.example.tallerapi.domain.clientes;
import com.example.tallerapi.domain.dto.clientesDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface clientesRepository extends CrudRepository<clientes, Long> {

    //Devuleve todos los cleintes
    List<clientes> findAll();
    //Devuelve cliente con ese id
    clientes findById(long id);
}
