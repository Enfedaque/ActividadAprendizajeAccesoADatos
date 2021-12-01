package com.example.tallerAPI.Repository;

import com.example.tallerAPI.Domain.Clientes;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {

    //Devuleve todos los cleintes
    List<Clientes> findAll();
    //Devuelve cliente con ese id
    Clientes findById(long id);
    //Añade un nuevo cliente
    Clientes addCliente(Clientes cliente);
    //Eliminar un cliente
    Clientes deleteCliente(long id);
}
