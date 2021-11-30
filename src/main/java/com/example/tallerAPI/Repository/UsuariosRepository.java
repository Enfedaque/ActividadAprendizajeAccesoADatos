package com.example.tallerAPI.Repository;

import com.example.tallerAPI.Domain.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Similar al DAO
@Repository
public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

    /*Metodos como los del DAO, todos los que necesite
    METODOS QUE ACCEDEN A LA BBDD Y RECOGEN DATOS
    * Los find... tienen su miga, ya que solo con ese nombre se encarga de buscar la info en la BBDD*/

    //Devuleve todos los usuarios
    List<Usuarios> findAll();
    //Devuelve usuarios con ese id
    Usuarios findById(long id);
    //Devuelve usuarios con una edad mayor que (>) la que se le pasa
    List<Usuarios> findByEdadGreaterThan(int edad);
}
