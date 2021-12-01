package com.example.tallerAPI.Repository;

import com.example.tallerAPI.Domain.Clientes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long> {

    //Devuleve todos los cleintes
    List<Clientes> findAll();
    //Devuelve cliente con ese id
    Clientes findById(long id);
}
